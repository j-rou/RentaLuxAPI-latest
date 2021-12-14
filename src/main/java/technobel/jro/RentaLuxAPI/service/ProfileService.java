package technobel.jro.RentaLuxAPI.service;


import technobel.jro.RentaLuxAPI.models.dto.ProfileDTO;
import technobel.jro.RentaLuxAPI.models.form.ProfileForm;

import java.util.List;

public interface ProfileService {


    List<ProfileDTO> getAll();
    ProfileDTO getProfileByUsername(String username);
    ProfileDTO insert(ProfileForm form);
    ProfileDTO delete(int id);
    ProfileDTO update(int id, ProfileForm form);


}
