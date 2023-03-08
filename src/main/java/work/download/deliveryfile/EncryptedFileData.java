package work.download.deliveryfile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EncryptedFileData {

    private String localPath;
    private String fileName;
    private Long fileSize;

}
