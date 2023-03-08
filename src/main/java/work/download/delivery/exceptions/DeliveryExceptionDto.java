package work.download.delivery.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeliveryExceptionDto {

    private DeliveryExceptionType type;
    private String message;

}
