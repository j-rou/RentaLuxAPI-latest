package technobel.jro.fenrirAPI.models.form;


import lombok.Data;
import org.springframework.validation.annotation.Validated;
import technobel.jro.fenrirAPI.models.entity.PlotEntity;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Validated
public class SkillForm {

    @NotBlank
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private int level;

}