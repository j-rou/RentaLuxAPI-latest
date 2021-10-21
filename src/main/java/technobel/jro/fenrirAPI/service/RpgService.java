package technobel.jro.fenrirAPI.service;


import technobel.jro.fenrirAPI.models.dto.RpgDTO;
import technobel.jro.fenrirAPI.models.form.RpgForm;

import java.util.List;

public interface RpgService {


    List<RpgDTO> getAll();
    RpgDTO getOne(int id);
    RpgDTO insert(RpgForm form);
    RpgDTO delete(int id);
    RpgDTO update(int id, RpgForm form);


}
