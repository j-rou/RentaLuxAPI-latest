package technobel.jro.fenrirAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.models.dto.SkillDTO;
import technobel.jro.fenrirAPI.models.entity.SkillEntity;
import technobel.jro.fenrirAPI.models.form.SkillForm;


@Service
public class SkillMapper {

    public SkillDTO toDTO(SkillEntity entity){

        if( entity == null ) {
            return null;
        }

        return SkillDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .level(entity.getLevel())
                .build();
    }


    public SkillEntity formToEntity(SkillForm form){
        if( form == null ) {
            return null;
        }

        SkillEntity Skills = new SkillEntity();

        Skills.setId(form.getId());
        Skills.setName(form.getName());
        Skills.setDescription(form.getDescription());
        Skills.setLevel(Skills.getLevel());


        return Skills;
    }


}
