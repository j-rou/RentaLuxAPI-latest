package technobel.jro.RentaLuxAPI.service;


import technobel.jro.RentaLuxAPI.models.dto.VehicleDTO;
import technobel.jro.RentaLuxAPI.models.form.VehicleForm;

import java.util.List;

public interface VehicleService {


    List<VehicleDTO> getAll();
    VehicleDTO getOne(int id);
    VehicleDTO insert(VehicleForm form);
    VehicleDTO delete(int id);
    VehicleDTO update(int id, VehicleForm form);

    List<VehicleDTO> getFromFilter(List<String> filtres);



}
