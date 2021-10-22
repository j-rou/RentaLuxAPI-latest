package technobel.jro.fenrirAPI.mapper;

import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.models.dto.ParticipantDTO;
import technobel.jro.fenrirAPI.models.entity.ParticipantEntity;
import technobel.jro.fenrirAPI.models.form.ParticipantForm;

import javax.servlet.http.Part;


@Service
public class ParticipantMapper {

    public ParticipantDTO toDTO(ParticipantEntity entity){

        if( entity == null ) {
            return null;
        }

        return ParticipantDTO.builder()
                .id( entity.getId() )
                .lastName(entity.getLastName())
                .firstName(entity.getFirstName())
                .address(entity.getAddress())
                .heroEntityId(entity.getHero().getId())
                .heroClassEntityId(entity.getHeroClass().getId())
                .build();
    }

    public ParticipantEntity formToEntity(ParticipantForm form){
        if( form == null ) {
            return null;
        }

        ParticipantEntity Participant = new ParticipantEntity();

        Participant.setId(form.getId());
        Participant.setLastName(form.getLastName());
        Participant.setFirstName(form.getFirstName());
        Participant.setAddress(form.getAddress());
        Participant.setHero(form.getHero());
        Participant.setHeroClass(form.getHeroClass());


        return Participant;
    }


}
