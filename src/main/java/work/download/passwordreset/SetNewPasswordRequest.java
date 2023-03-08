package work.download.passwordreset;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SetNewPasswordRequest {

    private String token;
    private String password;

}
