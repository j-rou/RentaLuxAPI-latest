package technobel.jro.fenrirAPI.service;


import technobel.jro.fenrirAPI.models.dto.PlotDTO;
import technobel.jro.fenrirAPI.models.form.PlotForm;

import java.util.List;

public interface PlotService {


    List<PlotDTO> getAll();
    PlotDTO getOne(int id);
    PlotDTO insert(PlotForm form);
    PlotDTO delete(int id);
    PlotDTO update(int id, PlotForm form);


}
