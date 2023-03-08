package work.download.delivery;

import lombok.Data;
import lombok.NoArgsConstructor;
import work.download.appuser.PublicAppUserDto;
import work.download.delivery.enums.DeliveryStatus;
import work.download.delivery.enums.NotifyMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
@NoArgsConstructor
public class BasicDeliveryDto extends PublicDeliveryDto {

    private String clientEmail;
    private NotifyMode notifyMode;
    private DeliveryStatus deliveryStatus;
    private String password;
    private String orderNumber;
    private String uuid;
    private LocalDate deliveryDate;
    private LocalDate deliveredAt;
    private String title;

    public String getDeliveryDateText() {
        if(deliveryDate == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy", Locale.ENGLISH);
        return deliveryDate.format(formatter);
    }

    public String getDeliveredAtText() {
        if(deliveredAt == null) return null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy", Locale.ENGLISH);
        return deliveredAt.format(formatter);
    }



}
