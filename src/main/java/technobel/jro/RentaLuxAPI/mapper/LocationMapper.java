package technobel.jro.RentaLuxAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.models.dto.LocationDTO;
import technobel.jro.RentaLuxAPI.models.entity.LocationEntity;
import technobel.jro.RentaLuxAPI.models.form.LocationForm;


@Service
public class LocationMapper {

    public LocationDTO toDTO(LocationEntity entity){

        if( entity == null ) {
            return null;
        }

        return LocationDTO.builder()
                .id( entity.getId() )
                .profileId( entity.getProfileId() )
                .vehiculeId( entity.getVehiculeId() )
                .dropSiteId(entity.getDropSiteId())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .upclassable(entity.isUpclassable())
                .upClassVehiculeId(entity.getUpClassVehiculeId())
                .payementStatus(entity.getPayementStatus())
                .invoiceAccount(entity.getInvoiceAccount())
                .build();
    }


    public LocationEntity formToEntity(LocationForm form){
        if( form == null ) {
            return null;
        }

        LocationEntity Location = new LocationEntity();

        Location.setId(form.getId());
        Location.setProfileId(form.getProfileId());
        Location.setVehiculeId(form.getVehiculeId());
        Location.setDropSiteId(form.getDropSiteId());
        Location.setStartDate(form.getStartDate());
        Location.setEndDate(form.getEndDate());
        Location.setUpclassable(form.isUpclassable());
        Location.setUpClassVehiculeId(form.getUpClassVehiculeId());
        Location.setPayementStatus(form.getPayementStatus());
        Location.setInvoiceAccount(form.getInvoiceAccount());

        return Location;
    }


}
