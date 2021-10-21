package technobel.jro.fenrirAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.models.dto.HeroDTO;
import technobel.jro.fenrirAPI.models.entity.HeroEntity;
import technobel.jro.fenrirAPI.models.form.HeroForm;


@Service
public class HeroMapper {

    public HeroDTO toDTO(HeroEntity entity){

        if( entity == null ) {
            return null;
        }

        return HeroDTO.builder()
                .id( entity.getId() )
                .name( entity.getName() )
                .clan( entity.getClan() )
                .heroClass(entity.getHeroClass())
                .skills(entity.getSkills())
                .build();
    }


    public HeroEntity formToEntity(HeroForm form){
        if( form == null ) {
            return null;
        }

        HeroEntity Hero = new HeroEntity();

        Hero.setId(form.getId());
        Hero.setName(form.getName());
        Hero.setClan(form.getClan());
        Hero.setHeroClass(form.getHeroClass());
        Hero.setSkills(form.getSkills());


        return Hero;
    }


}
