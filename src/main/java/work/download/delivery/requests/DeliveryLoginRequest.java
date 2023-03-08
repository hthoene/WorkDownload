package work.download.delivery.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeliveryLoginRequest {

    private Long deliveryId;
    private String password;

}
