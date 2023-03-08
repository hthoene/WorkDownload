package work.download.appuser;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PublicAppUserDto {

    private Long id;
    private String companyName;
    private String profilePictureUrl;
    private AppUserRole appUserRole;
    private Boolean verified;

}
