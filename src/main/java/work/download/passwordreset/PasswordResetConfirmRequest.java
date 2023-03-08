package work.download.passwordreset;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PasswordResetConfirmRequest {

    private String token;

}
