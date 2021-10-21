package technobel.jro.fenrirAPI.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.jro.fenrirAPI.models.entity.ClanEntity;
import technobel.jro.fenrirAPI.models.entity.HeroClassEntity;
import technobel.jro.fenrirAPI.models.entity.SkillEntity;

import java.util.List;

@Data
@Builder
public class HeroDTO {

    private int id;

    private String name;

    private ClanEntity clan;

    private HeroClassEntity heroClass;

    private List<SkillEntity> skills;


}