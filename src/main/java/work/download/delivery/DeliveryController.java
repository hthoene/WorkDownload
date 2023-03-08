package work.download.delivery;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import work.download.appuser.AppUser;
import work.download.delivery.requests.CreateDeliveryRequest;
import work.download.delivery.requests.DeliveryByUrlNameRequest;
import work.download.delivery.requests.DeliveryLoginRequest;
import work.download.responses.ResponseMessage;
import work.download.storage.FilesStorageService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/delivery")

public class DeliveryController {

    private final DeliveryService deliveryService;
    private final FilesStorageService filesStorageService;
    private final ModelMapper modelMapper;

    public DeliveryController(DeliveryService deliveryService, FilesStorageService filesStorageService, ModelMapper modelMapper) {
        this.deliveryService = deliveryService;
        this.filesStorageService = filesStorageService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("create")
    public ResponseEntity<ResponseMessage> createDelivery(@Valid @RequestBody CreateDeliveryRequest request, @AuthenticationPrincipal AppUser appUser) {
        deliveryService.createDelivery(request, appUser);
        return new ResponseEntity<>(new ResponseMessage("Created new Delivery successfully"), HttpStatus.OK);
    }

    @PostMapping("update")
    public ResponseEntity<BasicDeliveryDto> updateDelivery(@RequestBody BasicDeliveryDto basicDeliveryDto, @AuthenticationPrincipal AppUser appUser) {
        Delivery delivery = deliveryService.updateDelivery(basicDeliveryDto, appUser);
        return new ResponseEntity<>(modelMapper.map(delivery, BasicDeliveryDto.class), HttpStatus.OK);
    }

    @PostMapping("delete/{deliveryId}")
    public ResponseEntity<ResponseMessage> deleteDelivery(@AuthenticationPrincipal AppUser appUser, @PathVariable Long deliveryId) {
        deliveryService.deleteDelivery(deliveryId, appUser);
        return new ResponseEntity<>(new ResponseMessage("Success"), HttpStatus.OK);
    }

    @PostMapping("getAll")
    public ResponseEntity<List<BasicDeliveryDto>> getDeliveries(@AuthenticationPrincipal AppUser appUser) {
        List<Delivery> allDeliveriesOfUser = deliveryService.getAllDeliveriesOfUser(appUser);
        List<BasicDeliveryDto> collect = allDeliveriesOfUser.stream().map(delivery -> modelMapper.map(delivery, BasicDeliveryDto.class)).collect(Collectors.toList());
        return new ResponseEntity<>(collect, HttpStatus.OK);
    }

    @PostMapping("generateNewUrlName/{deliveryId}")
    public ResponseEntity<ResponseMessage> generateNewUrlName(@PathVariable("deliveryId") Long deliveryId, @AuthenticationPrincipal AppUser appUser) {
        String s = deliveryService.generateNewUrlName(deliveryId, appUser);
        return new ResponseEntity<>(new ResponseMessage(s), HttpStatus.OK);
    }

    @PostMapping("getByUrlName")
    public ResponseEntity<PublicDeliveryDto> getByUrlName(@RequestBody DeliveryByUrlNameRequest request) {

        PublicDeliveryDto publicByUrlName = deliveryService.getPublicByUrlName(request.getUrlName());

        return new ResponseEntity<>(publicByUrlName, HttpStatus.OK);
    }

    @PostMapping("clientLogin")
    public ResponseEntity<PrivateDeliveryDto> getByUrlName(@RequestBody DeliveryLoginRequest request) {

        Delivery byIdAndPassword = deliveryService.getByIdAndPassword(request.getDeliveryId(), request.getPassword());

        PrivateDeliveryDto publicDetailedByUrlName = deliveryService.getPrivateDeliveryDto(byIdAndPassword.getUrlName());

        return new ResponseEntity<>(publicDetailedByUrlName, HttpStatus.OK);
    }

}
