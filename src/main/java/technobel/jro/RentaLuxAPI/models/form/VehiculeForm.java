package technobel.jro.RentaLuxAPI.models.form;


import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class VehiculeForm {


    private int id;
    @NotBlank
    private String brand;
    @NotBlank
    private String model;
    @NotBlank
    private String category;


}
