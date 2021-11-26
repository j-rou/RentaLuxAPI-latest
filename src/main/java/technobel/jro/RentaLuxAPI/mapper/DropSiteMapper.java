package technobel.jro.RentaLuxAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.models.dto.DropSiteDTO;
import technobel.jro.RentaLuxAPI.models.entity.DropSiteEntity;
import technobel.jro.RentaLuxAPI.models.form.DropSiteForm;


@Service
public class DropSiteMapper {

    public DropSiteDTO toDTO(DropSiteEntity entity){

        if( entity == null ) {
            return null;
        }

        return DropSiteDTO.builder()
                .id( entity.getId() )
                .address( entity.getAddress() )
                .build();
    }


    public DropSiteEntity formToEntity(DropSiteForm form){
        if( form == null ) {
            return null;
        }

        DropSiteEntity DropSite = new DropSiteEntity();

        DropSite.setId(form.getId());
        DropSite.setAddress(form.getAddress());

        return DropSite;
    }


}
