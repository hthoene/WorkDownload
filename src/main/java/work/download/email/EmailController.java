package work.download.email;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import work.download.appuser.AppUser;
import work.download.delivery.Delivery;
import work.download.delivery.DeliveryService;
import work.download.email.request.ContactRequest;
import work.download.email.request.DeliveredEmailTemplateRequest;
import work.download.email.request.DeliveryCreatedEmailTemplateRequest;
import work.download.email.request.DeliveryIdRequest;
import work.download.responses.ResponseMessage;

@AllArgsConstructor
@RequestMapping("api/v1/email")
@RestController
public class EmailController {

    private final EmailTemplateGenerator emailTemplateGenerator;
    private final EmailSendService emailSendService;
    private final DeliveryService deliveryService;

    @PostMapping("template/delivered")
    public String getDeliveredEmailTemplate(@RequestBody DeliveredEmailTemplateRequest request) {
        return emailTemplateGenerator.createDeliveredEmail(request.getDeliverer(), request.getDeliveredAt(), request.getPassword(), "", "");
    }

    @PostMapping("template/deliveryCreated")
    public String getDeliveredEmailTemplate(@RequestBody DeliveryCreatedEmailTemplateRequest request) {
        return emailTemplateGenerator.createDeliveryCreatedEmail(request.getDeliverer(), request.getDeliveryDate(), request.getPassword(), "", "");
    }

    @PostMapping("sendDeliveryCreated")
    public ResponseEntity<ResponseMessage> sendDeliveryCreated(@RequestBody DeliveryIdRequest request, @AuthenticationPrincipal AppUser appUser) {

        Delivery delivery = deliveryService.getByIdAndUser(request.getDeliveryId(), appUser);

        String canSend = emailSendService.canSendDeliveryCreated(delivery);

        if(!canSend.equals("Success")) {
            return ResponseEntity.ok(new ResponseMessage(canSend));
        }

        String responseMessage = emailSendService.sendDeliveryCreatedToClient(delivery);

        return ResponseEntity.ok(new ResponseMessage(responseMessage));
    }

    @PostMapping("sendDelivered")
    public ResponseEntity<ResponseMessage> sendDelivered(@RequestBody DeliveryIdRequest request, @AuthenticationPrincipal AppUser appUser) {

        Delivery delivery = deliveryService.getByIdAndUser(request.getDeliveryId(), appUser);

        String canSend = emailSendService.canSendDelivered(delivery);

        if(!canSend.equals("Success")) {
            return ResponseEntity.ok(new ResponseMessage(canSend));
        }

        String responseMessage = emailSendService.sendDeliveredToClient(delivery);

        return ResponseEntity.ok(new ResponseMessage(responseMessage));
    }

    @PostMapping("sendContact")
    public ResponseEntity<ResponseMessage> sendContact(@RequestBody ContactRequest request) {
        String responseMessage = emailSendService.sendContact(request);
        return ResponseEntity.ok(new ResponseMessage(responseMessage));
    }

}
