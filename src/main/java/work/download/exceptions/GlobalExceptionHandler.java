package work.download.exceptions;

import org.modelmapper.ModelMapper;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import work.download.delivery.exceptions.DeliveryException;
import work.download.delivery.exceptions.DeliveryExceptionDto;
import work.download.deliveryfile.exceptions.DeliveryFileException;
import work.download.deliveryfile.exceptions.DeliveryFileExceptionDto;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    private final ModelMapper modelMapper;

    public GlobalExceptionHandler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @ExceptionHandler(
            DeliveryFileException.class
    )
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ResponseEntity<DeliveryFileExceptionDto> handleUploadException(DeliveryFileException exception) {

        DeliveryFileExceptionDto deliveryFileExceptionDto = new DeliveryFileExceptionDto();
        deliveryFileExceptionDto.setMessage(exception.getMessage());
        deliveryFileExceptionDto.setType(exception.getStatus());

        return new ResponseEntity<>(deliveryFileExceptionDto, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(DeliveryException.class)
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public ResponseEntity<DeliveryExceptionDto> onDeliveryError(DeliveryException exception) {

        return new ResponseEntity<>(modelMapper.map(exception, DeliveryExceptionDto.class), HttpStatus.BAD_REQUEST);


    }
}


