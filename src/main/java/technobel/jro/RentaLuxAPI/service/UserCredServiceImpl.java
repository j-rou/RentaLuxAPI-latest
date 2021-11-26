package technobel.jro.RentaLuxAPI.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.models.dto.UserCredDTO;
import technobel.jro.RentaLuxAPI.models.form.UserCredForm;
import technobel.jro.RentaLuxAPI.repository.UserCredRepository;

import java.util.List;


@Service("UserCredservice")
public class UserCredServiceImpl implements UserDetailsService, UserCredService {



    public final UserCredRepository repository;

    public UserCredServiceImpl(UserCredRepository rep) {
        this.repository = rep;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("Username pas trouvé")    );

    }


    @Override
    public List<UserCredDTO> getAll() {
        return null;
    }

    @Override
    public UserCredDTO getOne(int id) {
        return null;
    }

    @Override
    public UserCredDTO insert(UserCredForm form) {
        return null;
    }

    @Override
    public UserCredDTO delete(int id) {
        return null;
    }

    @Override
    public UserCredDTO update(int id, UserCredForm form) {
        return null;
    }
}
