package technobel.jro.RentaLuxAPI.models.form;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class UserCredForm {


    private int id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String accountType;



}