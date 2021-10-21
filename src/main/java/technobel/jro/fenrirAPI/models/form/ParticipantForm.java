package technobel.jro.fenrirAPI.models.form;


import lombok.Data;
import org.springframework.validation.annotation.Validated;
import technobel.jro.fenrirAPI.models.entity.HeroClassEntity;
import technobel.jro.fenrirAPI.models.entity.HeroEntity;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Validated
public class ParticipantForm {

    @NotBlank
    private int id;
    @NotBlank
    private String lastName;
    @NotBlank
    private String firstName;

    private String address;

    private HeroEntity hero;

    private HeroClassEntity heroClass;


}