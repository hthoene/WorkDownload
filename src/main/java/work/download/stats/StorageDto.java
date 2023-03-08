package work.download.stats;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StorageDto {

    private String storageUsedText;
    private String storageFreeText;
    private String storageTotalText;
    private String totalDiskStorageUsedText;

    private Long storageUsed;
    private Long storageFree;
    private Long storageTotal;
    private Long totalDiskStorageUsed;


}
