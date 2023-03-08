package work.download.email.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactRequest {

    private String email;
    private String name;
    private String message;

}
