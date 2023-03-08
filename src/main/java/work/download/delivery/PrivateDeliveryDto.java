package work.download.delivery;

import lombok.Data;
import lombok.NoArgsConstructor;
import work.download.appuser.PublicAppUserDto;

@Data
@NoArgsConstructor
public class PrivateDeliveryDto extends BasicDeliveryDto {

    private PublicAppUserDto owner;

}
