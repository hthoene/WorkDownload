package work.download.email.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeliveredEmailTemplateRequest {

    private String deliverer;
    private String deliveredAt;
    private String password;

}
