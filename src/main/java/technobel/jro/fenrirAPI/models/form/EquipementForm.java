package technobel.jro.fenrirAPI.models.form;


import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
public class EquipementForm {

    @NotBlank
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;


}