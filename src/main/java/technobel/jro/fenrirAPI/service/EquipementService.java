package technobel.jro.fenrirAPI.service;


import technobel.jro.fenrirAPI.models.dto.EquipementDTO;
import technobel.jro.fenrirAPI.models.form.EquipementForm;

import java.util.List;

public interface EquipementService {


    List<EquipementDTO> getAll();
    EquipementDTO getOne(int id);
    EquipementDTO insert(EquipementForm form);
    EquipementDTO delete(int id);
    EquipementDTO update(int id, EquipementForm form);


}
