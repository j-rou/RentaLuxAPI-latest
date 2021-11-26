package technobel.jro.RentaLuxAPI.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import technobel.jro.RentaLuxAPI.repository.*;
import technobel.jro.RentaLuxAPI.service.UserCredServiceImpl;

@Component
public class DataBaseFiller implements InitializingBean {


    private final DropSiteRepository dropSiteRepository;
    private final LocationRepository locationRepository;
    private final ProfileRepository profileRepository;
    private final UserCredRepository userCredRepository;
    private final VehiculeRepository vehiculeRepository;
    private final PasswordEncoder encoder;

    public DataBaseFiller(DropSiteRepository dropSiteRepository,
                          LocationRepository locationRepository,
                          ProfileRepository profileRepository,
                          UserCredRepository userCredRepository,
                          VehiculeRepository vehiculeRepository,
                          PasswordEncoder encoder
                            ){
        this.dropSiteRepository = dropSiteRepository;
        this.locationRepository = locationRepository;
        this.profileRepository = profileRepository;
        this.userCredRepository = userCredRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.encoder = encoder;
    }


    @Override
    public void afterPropertiesSet() throws Exception {



    }




}
