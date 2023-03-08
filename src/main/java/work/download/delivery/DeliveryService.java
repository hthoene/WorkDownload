package work.download.delivery;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;
import work.download.appuser.AppUser;
import work.download.appuser.AppUserRepository;
import work.download.delivery.enums.DeliveryStatus;
import work.download.delivery.exceptions.DeliveryException;
import work.download.delivery.exceptions.DeliveryExceptionType;
import work.download.delivery.requests.CreateDeliveryRequest;
import work.download.delivery.requests.DeliveryLoginRequest;
import work.download.deliveryfile.FileLocationRequest;
import work.download.storage.FilesStorageService;
import work.download.utils.RandomString;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final AppUserRepository appUserRepository;

    private final FilesStorageService filesStorageService;

    private final ModelMapper modelMapper;

    public DeliveryService(DeliveryRepository deliveryRepository, AppUserRepository appUserRepository, FilesStorageService filesStorageService, ModelMapper modelMapper) {
        this.deliveryRepository = deliveryRepository;
        this.appUserRepository = appUserRepository;
        this.filesStorageService = filesStorageService;
        this.modelMapper = modelMapper;
    }

    private Delivery getById(Long id) {
        Optional<Delivery> byId = deliveryRepository.findById(id);
        if(byId.isEmpty()) {
            throw new DeliveryException("Delivery not found", DeliveryExceptionType.DELIVERY_NOT_FOUND);
        }
        return byId.get();
    }

    public String getUuidById(Long id) {
        Delivery byId = getById(id);
        return byId.getUuid();
    }

    public PublicDeliveryDto getPublicByUrlName(String urlName) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        Delivery deliveryByUrlName = deliveryRepository.findDeliveryByUrlName(urlName);
        if(deliveryByUrlName == null) {
            throw new DeliveryException("No delivery with url found", DeliveryExceptionType.DELIVERY_NOT_FOUND);
        }
        return mapper.map(deliveryByUrlName, PublicDeliveryDto.class);
    }

    public PrivateDeliveryDto getPrivateDeliveryDto(String urlName) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        Delivery deliveryByUrlName = deliveryRepository.findDeliveryByUrlName(urlName);
        if(deliveryByUrlName == null) {
            throw new DeliveryException("No delivery with url found", DeliveryExceptionType.DELIVERY_NOT_FOUND);
        }

        return mapper.map(deliveryByUrlName, PrivateDeliveryDto.class);
    }

    public Delivery getByIdAndUser(Long id, AppUser appUser) {
        Delivery delivery = getById(id);

        if(delivery.getOwner().getId() != appUser.getId()) {
            throw new DeliveryException("Authentication failed", DeliveryExceptionType.AUTHENTICATION);
        }
        return delivery;
    }

    public Delivery getByIdAndPassword(Long id, String password) {
        Delivery delivery = getById(id);

        if(!delivery.getPassword().equals(password)) {
            throw new DeliveryException("Authentication failed", DeliveryExceptionType.AUTHENTICATION);
        }
        return delivery;
    }

    public Delivery getByDeliveryLogin(DeliveryLoginRequest request) {
        return getByIdAndPassword(request.getDeliveryId(), request.getPassword());
    }

    public Delivery updateDelivery(BasicDeliveryDto deliveryDto, AppUser appUser) {
        Delivery delivery = getByIdAndUser(deliveryDto.getId(), appUser);
        if(deliveryDto.getTitle() != null) {
            if(deliveryDto.getTitle().isBlank()) {
                throw new DeliveryException("Title cannot be empty", DeliveryExceptionType.ILLEGAL_ARGUMENT);
            }
            delivery.setTitle(deliveryDto.getTitle());
        }



        if(deliveryDto.getDeliveryDate() != null) {

            delivery.setDeliveryDate(deliveryDto.getDeliveryDate());
        }
        if(deliveryDto.getClientEmail() != null) {
            delivery.setClientEmail(deliveryDto.getClientEmail());
        }
        if(deliveryDto.getDeliveryStatus() != null) {
            delivery.setDeliveryStatus(deliveryDto.getDeliveryStatus());
            if(deliveryDto.getDeliveryStatus().equals(DeliveryStatus.DELIVERED)) {
                delivery.setDeliveredAt(LocalDate.now());
            } else {
                delivery.setDeliveredAt(null);
            }
        }
        if(deliveryDto.getNotifyMode() != null) {
            delivery.setNotifyMode(deliveryDto.getNotifyMode());
        }
        if(deliveryDto.getPassword() != null) {
            if(deliveryDto.getPassword().isBlank()) {
                throw new DeliveryException("Password field is empty", DeliveryExceptionType.ILLEGAL_ARGUMENT);
            }
            if(!deliveryDto.getPassword().equals(delivery.getPassword())) {
                filesStorageService.updatePassword(delivery, deliveryDto.getPassword());

            }
            delivery.setPassword(deliveryDto.getPassword());

        }
        if(deliveryDto.getOrderNumber() != null) {
            delivery.setOrderNumber(deliveryDto.getOrderNumber());
        }

        return deliveryRepository.save(delivery);
    }

    public void createDelivery(CreateDeliveryRequest request, AppUser appUser) {

        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);

        Delivery delivery = mapper.map(request, Delivery.class);
        delivery.setDiskPath(filesStorageService.createPathWithId(delivery.getUuid()).toString());
        delivery.setUrlName(RandomString.randomString(8));
        appUser.addDelivery(delivery);
        appUserRepository.save(appUser);

    }

    public List<Delivery> getAllDeliveriesOfUser(AppUser appUser) {
        return deliveryRepository.findDeliveriesByOwnerId(appUser.getId());
    }


    public String generateNewUrlName(Long deliveryId, AppUser appUser) {
        Delivery byIdAndUser = getByIdAndUser(deliveryId, appUser);
        String newUrl = RandomString.randomString(8);
        byIdAndUser.setUrlName(newUrl);
        Delivery save = deliveryRepository.save(byIdAndUser);
        return save.getUrlName();
    }


    public void deleteFile(FileLocationRequest request, AppUser appUser) {

        Delivery delivery = getByIdAndUser(request.getDeliveryId(), appUser);

        filesStorageService.delete(delivery, request.getLocalPath());

    }

    public void deleteFolder(FileLocationRequest request, AppUser appUser) {

        Delivery delivery = getByIdAndUser(request.getDeliveryId(), appUser);

        filesStorageService.deleteFolder(delivery, request.getLocalPath());

    }

    public void deleteDelivery(Long deliveryId, AppUser appUser) {
        Delivery byIdAndUser = getByIdAndUser(deliveryId, appUser);
        filesStorageService.deleteDelivery(byIdAndUser);

        appUser.getDeliveries().removeIf(d -> d.getId() == deliveryId);
        appUserRepository.save(appUser);
    }
}
