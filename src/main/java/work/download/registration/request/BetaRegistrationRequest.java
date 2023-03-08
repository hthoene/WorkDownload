package work.download.registration.request;

import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class BetaRegistrationRequest extends RegistrationRequest {

    private String betaCode;

}
