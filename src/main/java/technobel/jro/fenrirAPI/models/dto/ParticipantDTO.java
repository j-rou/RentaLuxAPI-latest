package technobel.jro.fenrirAPI.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.jro.fenrirAPI.models.entity.HeroClassEntity;
import technobel.jro.fenrirAPI.models.entity.HeroEntity;

import java.util.List;


@Data
@Builder
public class ParticipantDTO {

    private int id;

    private String lastName;
    private String firstName;
    private String address;

    private int heroEntityId;

    private int heroClassEntityId;



}


