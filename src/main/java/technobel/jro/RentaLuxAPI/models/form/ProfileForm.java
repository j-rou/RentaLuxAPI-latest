package technobel.jro.RentaLuxAPI.models.form;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class ProfileForm {

    @NotBlank
    private int id;

    @NotBlank
    private String address;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String tel;

    private String tva;

    private int[] rentalsId;



}
