package technobel.jro.fenrirAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.models.dto.EquipementDTO;
import technobel.jro.fenrirAPI.models.entity.EquipementEntity;
import technobel.jro.fenrirAPI.models.form.EquipementForm;


@Service
public class EquipementMapper {

    public EquipementDTO toDTO(EquipementEntity entity){

        if( entity == null ) {
            return null;
        }

        return EquipementDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .build();
    }


    public EquipementEntity formToEntity(EquipementForm form){
        if( form == null ) {
            return null;
        }

        EquipementEntity Equipement = new EquipementEntity();

        Equipement.setId(form.getId());
        Equipement.setName(form.getName());
        Equipement.setDescription(form.getDescription());


        return Equipement;
    }


}
