package work.download.appuser.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserStorageDto {

    private Long totalStorageAvailable;
    private Long usedStorage;

    private String totalStorageAvailableText;
    private String usedStorageText;

}
