package technobel.jro.fenrirAPI.service;


import technobel.jro.fenrirAPI.models.dto.HeroClassDTO;
import technobel.jro.fenrirAPI.models.form.HeroClassForm;

import java.util.List;

public interface HeroClassService {


    List<HeroClassDTO> getAll();
    HeroClassDTO getOne(int id);
    HeroClassDTO insert(HeroClassForm form);
    HeroClassDTO delete(int id);
    HeroClassDTO update(int id, HeroClassForm form);


}
