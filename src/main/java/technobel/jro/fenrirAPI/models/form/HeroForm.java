package technobel.jro.fenrirAPI.models.form;


import lombok.Data;
import org.springframework.validation.annotation.Validated;
import technobel.jro.fenrirAPI.models.entity.ClanEntity;
import technobel.jro.fenrirAPI.models.entity.HeroClassEntity;
import technobel.jro.fenrirAPI.models.entity.SkillEntity;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Validated
public class HeroForm {

    @NotBlank
    private int id;
    @NotBlank
    private String name;

    private ClanEntity clan;

    private HeroClassEntity heroClass;

    private List<SkillEntity> skills;



}