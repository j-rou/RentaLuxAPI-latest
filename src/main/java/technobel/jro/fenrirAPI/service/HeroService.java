package technobel.jro.fenrirAPI.service;


import technobel.jro.fenrirAPI.models.dto.HeroDTO;
import technobel.jro.fenrirAPI.models.form.HeroForm;

import java.util.List;

public interface HeroService {


    List<HeroDTO> getAll();
    HeroDTO getOne(int id);
    HeroDTO insert(HeroForm form);
    HeroDTO delete(int id);
    HeroDTO update(int id, HeroForm form);


}
