package technobel.jro.RentaLuxAPI.models.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class ProfileDTO {

    private int id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String tel;
    private String tva;
    private int[] rentalsId;


}
