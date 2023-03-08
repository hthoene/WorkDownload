package work.download.admindelivery;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import work.download.delivery.Delivery;
import work.download.delivery.DeliveryRepository;
import work.download.delivery.DeliveryService;

import java.util.List;

@Service
@AllArgsConstructor
public class AdminDeliveryService {

    private final DeliveryService deliveryService;
    private final DeliveryRepository deliveryRepository;

    public List<Delivery> loadDeliveriesOrderedByUnused(int amount) {
        return deliveryRepository.findAllOrderedByUnused(PageRequest.of(0, amount));
    }

}
