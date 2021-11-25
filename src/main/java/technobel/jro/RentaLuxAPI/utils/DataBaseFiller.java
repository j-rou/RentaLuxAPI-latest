package technobel.jro.RentaLuxAPI.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import technobel.jro.RentaLuxAPI.models.entity.*;
import technobel.jro.RentaLuxAPI.repository.*;

import java.util.List;

@Component
public class DataBaseFiller implements InitializingBean {


    private final ProfileRepository profileRepository;

    private final PasswordEncoder encoder;

    public DataBaseFiller(ProfileRepository profileRepository,PasswordEncoder encoder) {
        this.profileRepository = profileRepository;
        this.encoder = encoder;
    }


    @Override
    public void afterPropertiesSet() throws Exception {



    }




}
