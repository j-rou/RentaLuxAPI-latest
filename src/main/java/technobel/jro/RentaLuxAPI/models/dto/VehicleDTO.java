package technobel.jro.RentaLuxAPI.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.jro.RentaLuxAPI.models.entity.BrandEntity;
import technobel.jro.RentaLuxAPI.models.entity.UsageEntity;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class VehicleDTO {

    private int id;
    private BrandEntity brand;
    private String model;
    private UsageEntity usage;


}
