package technobel.jro.RentaLuxAPI.models.form;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class DropSiteForm {


    private int id;
    @NotBlank
    private String address;

}
