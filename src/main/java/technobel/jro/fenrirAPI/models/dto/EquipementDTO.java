package technobel.jro.fenrirAPI.models.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EquipementDTO {


    private int id;

    private String name;

    private String description;


}