package technobel.jro.fenrirAPI.models.dto;


import lombok.Builder;
import lombok.Data;
import technobel.jro.fenrirAPI.models.entity.EquipementEntity;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
public class HeroClassDTO {

    @NotBlank
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private int[] availableEquipementId;


}