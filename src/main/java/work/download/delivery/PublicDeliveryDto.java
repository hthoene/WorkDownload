package work.download.delivery;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PublicDeliveryDto {

    private Long id;
    private String urlName;

}
