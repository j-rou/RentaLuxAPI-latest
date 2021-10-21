package technobel.jro.fenrirAPI.service;


import technobel.jro.fenrirAPI.models.dto.ClanDTO;
import technobel.jro.fenrirAPI.models.form.ClanForm;

import java.util.List;

public interface ClanService {


    List<ClanDTO> getAll();
    ClanDTO getOne(int id);
    ClanDTO insert(ClanForm form);
    ClanDTO delete(int id);
    ClanDTO update(int id, ClanForm form);


}
