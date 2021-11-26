package technobel.jro.RentaLuxAPI.service;


import technobel.jro.RentaLuxAPI.models.dto.VehiculeDTO;
import technobel.jro.RentaLuxAPI.models.form.VehiculeForm;

import java.util.List;

public interface VehiculeService {


    List<VehiculeDTO> getAll();
    VehiculeDTO getOne(int id);
    VehiculeDTO insert(VehiculeForm form);
    VehiculeDTO delete(int id);
    VehiculeDTO update(int id, VehiculeForm form);


}
