package technobel.jro.fenrirAPI.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import technobel.jro.fenrirAPI.repository.UserRepository;

@Service
public class UserServiceImpl  implements UserDetailsService {



    public final UserRepository repository;

    public UserServiceImpl(UserRepository rep) {
        this.repository = rep;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository.findByUsername(username)
                .orElseThrow( () -> new UsernameNotFoundException("Username pas trouvé")    );


    }





}
