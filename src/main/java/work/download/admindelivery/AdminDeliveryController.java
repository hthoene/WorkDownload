package work.download.admindelivery;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.download.appuser.AppUser;
import work.download.delivery.BasicDeliveryDto;
import work.download.delivery.Delivery;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/admin/delivery")
@AllArgsConstructor
public class AdminDeliveryController {

    private final AdminDeliveryService adminDeliveryService;
    private final ModelMapper modelMapper;

    @PostMapping("getOldDeliveries/{amount}")
    public ResponseEntity<List<AdminDeliveryDto>> getOldDeliveries(@PathVariable int amount, @AuthenticationPrincipal AppUser appUser) {

        if(!appUser.getAppUserRole().toString().equals("ADMIN")) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }


        List<Delivery> deliveries = adminDeliveryService.loadDeliveriesOrderedByUnused(amount);
        return new ResponseEntity<>(deliveries.stream().map(delivery -> modelMapper.map(delivery, AdminDeliveryDto.class)).collect(Collectors.toList()), HttpStatus.OK);
    }


}
