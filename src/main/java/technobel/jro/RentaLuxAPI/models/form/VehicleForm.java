package technobel.jro.RentaLuxAPI.models.form;


import lombok.Data;
import org.springframework.validation.annotation.Validated;
import technobel.jro.RentaLuxAPI.models.entity.BrandEntity;
import technobel.jro.RentaLuxAPI.models.entity.UsageEntity;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class VehicleForm {


    private int id;
    @NotBlank
    private BrandEntity brand;
    @NotBlank
    private String model;
    @NotBlank
    private UsageEntity usage;


}
