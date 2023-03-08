package work.download.deliveryfile;

import lombok.Data;
import lombok.NoArgsConstructor;
import work.download.delivery.requests.DeliveryLoginRequest;

@Data
@NoArgsConstructor
public class FileLocationRequest extends DeliveryLoginRequest {

    private String localPath;

}
