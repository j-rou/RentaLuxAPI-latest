package technobel.jro.RentaLuxAPI.models.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class VehiculeDTO {

    private int id;

    private String brand;
    private String model;
    private String category;


}
