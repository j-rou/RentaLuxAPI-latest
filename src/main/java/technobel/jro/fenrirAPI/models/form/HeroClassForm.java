package technobel.jro.fenrirAPI.models.form;


import lombok.*;
import org.springframework.validation.annotation.Validated;
import technobel.jro.fenrirAPI.models.entity.EquipementEntity;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Validated
public class HeroClassForm {


    @NotBlank
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private List<EquipementEntity> availableEquipement;


}