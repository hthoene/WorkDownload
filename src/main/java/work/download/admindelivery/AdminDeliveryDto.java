package work.download.admindelivery;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AdminDeliveryDto {

    private Long id;
    private LocalDateTime lastAccess;

}
