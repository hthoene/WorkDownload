package work.download.deliveryfile;

import lombok.Data;
import lombok.NoArgsConstructor;
import work.download.delivery.requests.DeliveryLoginRequest;

@Data
@NoArgsConstructor
public class FileRenameRequest extends FileLocationRequest {

    private String renameTo;

}
