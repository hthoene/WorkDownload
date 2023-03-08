package work.download.appuser;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PrivateAppUserDto extends PublicAppUserDto {

    private String email;
    private LocalDateTime accountCreationDate;
    private Long storage;

}
