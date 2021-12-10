package technobel.jro.RentaLuxAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.models.dto.VehicleDTO;
import technobel.jro.RentaLuxAPI.models.entity.VehicleEntity;
import technobel.jro.RentaLuxAPI.models.form.VehicleForm;


@Service
public class VehicleMapper {

    public VehicleDTO toDTO(VehicleEntity entity){

        if( entity == null ) {
            return null;
        }

        return VehicleDTO.builder()
                .id( entity.getId() )
                .brand(entity.getBrand())
                .model(entity.getModel())
                .usage(entity.getUsage())
                .build();
    }


    public VehicleEntity formToEntity(VehicleForm form){
        if( form == null ) {
            return null;
        }

        VehicleEntity Vehicle = new VehicleEntity();

        Vehicle.setId(form.getId());
        Vehicle.setBrand(form.getBrand());
        Vehicle.setModel(form.getModel());
        Vehicle.setUsage(form.getUsage());

        return Vehicle;
    }


}
