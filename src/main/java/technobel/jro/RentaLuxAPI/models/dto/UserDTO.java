package technobel.jro.RentaLuxAPI.models.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder

public class UserDTO {

    private int id;

    private String email;

    private String password;

    private String accountType;



}