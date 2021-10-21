package technobel.jro.fenrirAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.models.dto.RpgDTO;
import technobel.jro.fenrirAPI.models.entity.RpgEntity;
import technobel.jro.fenrirAPI.models.form.RpgForm;


@Service
public class RpgMapper {

    public RpgDTO toDTO(RpgEntity entity){

        if( entity == null ) {
            return null;
        }

        return RpgDTO.builder()
                .id(entity.getId())
                .plot(entity.getPlot())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .location(entity.getLocation())
                .price(entity.getPrice())
                .build();
    }


    public RpgEntity formToEntity(RpgForm form){
        if( form == null ) {
            return null;
        }

        RpgEntity Rpg = new RpgEntity();

        Rpg.setId(form.getId());
        Rpg.setPlot(form.getPlot());
        Rpg.setStartDate(form.getStartDate());
        Rpg.setEndDate(form.getEndDate());
        Rpg.setLocation(form.getLocation());
        Rpg.setPrice(form.getPrice());

        return Rpg;
    }


}
