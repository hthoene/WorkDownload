package work.download.deliveryfile.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeliveryFileExceptionDto {

    private String message;
    private DeliveryFileExceptionType type;

}
