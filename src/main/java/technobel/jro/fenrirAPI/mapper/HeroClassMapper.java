package technobel.jro.fenrirAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.models.dto.HeroClassDTO;
import technobel.jro.fenrirAPI.models.entity.HeroClassEntity;
import technobel.jro.fenrirAPI.models.form.ClanForm;
import technobel.jro.fenrirAPI.models.form.HeroClassForm;


@Service
public class HeroClassMapper {

    public HeroClassDTO toDTO(HeroClassEntity entity){

        if( entity == null ) {
            return null;
        }

        return HeroClassDTO.builder()
                .id( entity.getId() )
                .name( entity.getName() )
                .availableEquipement( entity.getAvailableEquipement() )
                .build();
    }


    public HeroClassEntity formToEntity(HeroClassForm form){
        if( form == null ) {
            return null;
        }

        HeroClassEntity HeroClass = new HeroClassEntity();

        HeroClass.setId(form.getId());
        HeroClass.setName(form.getName());
        HeroClass.setAvailableEquipement(form.getAvailableEquipement());


        return HeroClass;
    }


}