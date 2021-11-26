package technobel.jro.RentaLuxAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.models.dto.VehiculeDTO;
import technobel.jro.RentaLuxAPI.models.entity.VehiculeEntity;
import technobel.jro.RentaLuxAPI.models.form.VehiculeForm;


@Service
public class VehiculeMapper {

    public VehiculeDTO toDTO(VehiculeEntity entity){

        if( entity == null ) {
            return null;
        }

        return VehiculeDTO.builder()
                .id( entity.getId() )
                .brand( entity.getBrand() )
                .model( entity.getModel() )
                .category(entity.getCategory())
                .build();
    }


    public VehiculeEntity formToEntity(VehiculeForm form){
        if( form == null ) {
            return null;
        }

        VehiculeEntity Vehicule = new VehiculeEntity();

        Vehicule.setId(form.getId());
        Vehicule.setBrand(form.getBrand());
        Vehicule.setModel(form.getModel());
        Vehicule.setCategory(form.getCategory());

        return Vehicule;
    }


}
