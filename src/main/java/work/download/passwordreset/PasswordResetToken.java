package work.download.passwordreset;

import lombok.Data;
import lombok.NoArgsConstructor;
import work.download.appuser.AppUser;
import work.download.utils.RandomString;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String token = RandomString.randomString(20);

    @OneToOne(fetch = FetchType.EAGER, optional = false, targetEntity = AppUser.class)
    @JoinColumn(name = "user_id", unique = true)
    private AppUser appUser;

    private LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(15);

}
