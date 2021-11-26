package technobel.jro.RentaLuxAPI.service;


import technobel.jro.RentaLuxAPI.models.dto.DropSiteDTO;
import technobel.jro.RentaLuxAPI.models.form.DropSiteForm;

import java.util.List;

public interface DropSiteService {


    List<DropSiteDTO> getAll();
    DropSiteDTO getOne(int id);
    DropSiteDTO insert(DropSiteForm form);
    DropSiteDTO delete(int id);
    DropSiteDTO update(int id, DropSiteForm form);


}
