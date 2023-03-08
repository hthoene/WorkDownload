package work.download.delivery.exceptions;

import lombok.Getter;

@Getter
public class DeliveryException extends RuntimeException {

    private DeliveryExceptionType type;

    public DeliveryException(String message, DeliveryExceptionType type) {
        super(message);
        this.type = type;
    }
}
