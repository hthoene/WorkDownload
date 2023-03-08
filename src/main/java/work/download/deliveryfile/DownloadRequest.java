package work.download.deliveryfile;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DownloadRequest {

    private Long deliveryId;
    private String password;
    private String localPath;

}
