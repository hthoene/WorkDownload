package work.download.deliveryfile;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileDto {

    private String localPath;
    private String fileName;
    private Long sizeInBytes;

}
