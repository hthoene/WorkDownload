package work.download.deliveryfile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FolderDto {

    private String folderName;
    private int folderElements;
    private String localPath;

}
