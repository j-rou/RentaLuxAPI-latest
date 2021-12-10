package technobel.jro.RentaLuxAPI.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import technobel.jro.RentaLuxAPI.models.dto.LoginSuccessDTO;
import technobel.jro.RentaLuxAPI.models.entity.UserCredEntity;
import technobel.jro.RentaLuxAPI.models.form.LoginForm;
import technobel.jro.RentaLuxAPI.repository.UserCredRepository;
import technobel.jro.RentaLuxAPI.security.JwtProvider;

@Service
public class SessionServiceImpl implements SessionService {

    private final UserCredRepository repository;
    private final AuthenticationManager manager;
    private final JwtProvider provider;

    public SessionServiceImpl(UserCredRepository repository, AuthenticationManager manager, JwtProvider provider) {
        this.repository = repository;
        this.manager = manager;
        this.provider = provider;
    }

    @Override
    public LoginSuccessDTO login(LoginForm form) {
        UserCredEntity userCredEntity = repository.findByUsername(form.getUsername())
                .orElseThrow( () -> new UsernameNotFoundException("L'utilisateur n'existe pas"));

        // creer l'authentication
        Authentication authentication = new UsernamePasswordAuthenticationToken(form.getUsername(),form.getPassword());
        // tester l'authentication
        manager.authenticate( authentication );

        // -> ok : creer token et le renvoyer
        return LoginSuccessDTO.builder()
                .jwt( provider.createToken(userCredEntity.getUsername(), userCredEntity.getRoles()) )
                .username( userCredEntity.getUsername() )
                .userType(userCredEntity.getAccountType())
                .build()  ;
    }

}
