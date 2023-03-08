package work.download.delivery.requests;

import lombok.Data;
import lombok.NoArgsConstructor;
import work.download.delivery.enums.NotifyMode;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
public class CreateDeliveryRequest {

    @NotBlank
    private String title;

    private String clientEmail = "/";

    private NotifyMode notifyMode = NotifyMode.NONE;

    private String orderNumber = UUID.randomUUID().toString();

    @NotBlank
    private String password;

    private LocalDate deliveryDate;

}
