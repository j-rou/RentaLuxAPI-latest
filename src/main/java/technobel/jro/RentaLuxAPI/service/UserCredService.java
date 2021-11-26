package technobel.jro.RentaLuxAPI.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.models.dto.UserCredDTO;
import technobel.jro.RentaLuxAPI.models.form.UserCredForm;
import technobel.jro.RentaLuxAPI.repository.UserCredRepository;

import java.util.List;


public interface UserCredService {


    List<UserCredDTO> getAll();
    UserCredDTO getOne(int id);
    UserCredDTO insert(UserCredForm form);
    UserCredDTO delete(int id);
    UserCredDTO update(int id, UserCredForm form);
    

    

}
