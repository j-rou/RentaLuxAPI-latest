package technobel.jro.fenrirAPI.service;


import technobel.jro.fenrirAPI.models.dto.ParticipantDTO;
import technobel.jro.fenrirAPI.models.form.ParticipantForm;

import java.util.List;

public interface ParticipantService {


    List<ParticipantDTO> getAll();
    ParticipantDTO getOne(int id);
    ParticipantDTO insert(ParticipantForm form);
    ParticipantDTO delete(int id);
    ParticipantDTO update(int id, ParticipantForm form);


}
