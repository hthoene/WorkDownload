package work.download.deliveryfile.exceptions;

import lombok.Getter;

@Getter
public class DeliveryFileException extends RuntimeException {

    private DeliveryFileExceptionType status;

    public DeliveryFileException(String message, DeliveryFileExceptionType status) {
        super(message);
        this.status = status;
    }
}
