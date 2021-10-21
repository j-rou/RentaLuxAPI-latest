package technobel.jro.fenrirAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.models.dto.PlotDTO;
import technobel.jro.fenrirAPI.models.entity.PlotEntity;
import technobel.jro.fenrirAPI.models.form.PlotForm;


@Service
public class PlotMapper {

    public PlotDTO toDTO(PlotEntity entity){

        if( entity == null ) {
            return null;
        }

        return PlotDTO.builder()
                .id( entity.getId() )
                .name( entity.getName() )
                .description(entity.getDescription())
                .build();
    }


    public PlotEntity formToEntity(PlotForm form){
        if( form == null ) {
            return null;
        }

        PlotEntity Plot = new PlotEntity();

        Plot.setId(form.getId());
        Plot.setName(form.getName());
        Plot.setDescription(form.getDescription());


        return Plot;
    }


}
