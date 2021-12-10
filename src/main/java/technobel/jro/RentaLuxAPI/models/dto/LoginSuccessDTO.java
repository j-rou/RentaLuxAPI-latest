package technobel.jro.RentaLuxAPI.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginSuccessDTO {

    private String jwt;
    private String username;

//
//    TTEEEEEEEEEEEEEEEEST
    private String userType;
//
//
//

}
