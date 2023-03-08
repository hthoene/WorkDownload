package work.download.email.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeliveryCreatedEmailTemplateRequest {

        private String deliverer;
        private String deliveryDate;
        private String password;

}
