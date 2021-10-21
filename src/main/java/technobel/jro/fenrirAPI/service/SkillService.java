package technobel.jro.fenrirAPI.service;


import technobel.jro.fenrirAPI.models.dto.SkillDTO;
import technobel.jro.fenrirAPI.models.form.SkillForm;

import java.util.List;

public interface SkillService {


    List<SkillDTO> getAll();
    SkillDTO getOne(int id);
    SkillDTO insert(SkillForm form);
    SkillDTO delete(int id);
    SkillDTO update(int id, SkillForm form);


}
