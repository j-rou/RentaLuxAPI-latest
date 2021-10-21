package technobel.jro.fenrirAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.models.dto.ClanDTO;
import technobel.jro.fenrirAPI.models.entity.ClanEntity;
import technobel.jro.fenrirAPI.models.form.ClanForm;


@Service
public class ClanMapper {

    public ClanDTO toDTO(ClanEntity entity){

        if( entity == null ) {
            return null;
        }

        return ClanDTO.builder()
                .id( entity.getId() )
                .name( entity.getName() )
                .bio( entity.getBio() )
                .build();
    }


    public ClanEntity formToEntity(ClanForm form){
        if( form == null ) {
            return null;
        }

        ClanEntity Clan = new ClanEntity();

        Clan.setId(form.getId());
        Clan.setName(form.getName());
        Clan.setBio(form.getBio());

        return Clan;
    }


}
