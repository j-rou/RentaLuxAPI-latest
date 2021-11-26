package technobel.jro.RentaLuxAPI.service;


import technobel.jro.RentaLuxAPI.models.dto.LocationDTO;
import technobel.jro.RentaLuxAPI.models.form.LocationForm;

import java.util.List;

public interface LocationService {


    List<LocationDTO> getAll();
    LocationDTO getOne(int id);
    LocationDTO insert(LocationForm form);
    LocationDTO delete(int id);
    LocationDTO update(int id, LocationForm form);


}
