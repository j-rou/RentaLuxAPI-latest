package technobel.jro.RentaLuxAPI.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import technobel.jro.RentaLuxAPI.models.entity.BrandEntity;
import technobel.jro.RentaLuxAPI.models.entity.UsageEntity;
import technobel.jro.RentaLuxAPI.models.entity.UserCredEntity;
import technobel.jro.RentaLuxAPI.models.entity.VehicleEntity;
import technobel.jro.RentaLuxAPI.repository.*;

import java.util.List;

@Component
public class DataBaseFiller implements InitializingBean {


    private final PasswordEncoder encoder;
    private final DropSiteRepository dropSiteRepository;
    private final LocationRepository locationRepository;
    private final ProfileRepository profileRepository;
    private final UserCredRepository userCredRepository;
    private final VehicleRepository vehiculeRepository;
    private final BrandRepository brandRepository;
    private final UsageRepository usageRepository;

    public DataBaseFiller(PasswordEncoder encoder,
                          DropSiteRepository dropSiteRepository,
                          LocationRepository locationRepository,
                          ProfileRepository profileRepository,
                          UserCredRepository userCredRepository,
                          VehicleRepository vehiculeRepository,
                          BrandRepository brandRepository,
                          UsageRepository usageRepository){

        this.encoder = encoder;
        this.dropSiteRepository = dropSiteRepository;
        this.locationRepository = locationRepository;
        this.profileRepository = profileRepository;
        this.userCredRepository = userCredRepository;
        this.vehiculeRepository = vehiculeRepository;
        this.brandRepository = brandRepository;
        this.usageRepository = usageRepository;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

//        UserCredEntity userCred1 = new UserCredEntity();
//        userCred1.setUsername("admin2");
//        userCred1.setEmail("admin2@mail.com");
//        userCred1.setPassword(encoder.encode("pass"));
//        userCred1.setAccountType("admin");
//        userCred1.setAccountNonExpired(true);
//        userCred1.setAccountNonLocked(true);
//        userCred1.setCredentialsNonExpired(true);
//        userCred1.setEnabled(true);
//        userCred1.setRoles(List.of("ADMIN"));
//        userCredRepository.save(userCred1);
//
//        DropSiteEntity drop1 = new DropSiteEntity();
//        drop1.setAddress("Avenue d'Houffalize 1 - 6800 Libramont");
//        dropSiteRepository.save(drop1);
//
//        BrandEntity toyota = new BrandEntity();
//        toyota.setName("Toyota");
//        brandRepository.save(toyota);
//
//        UsageEntity utilitaire = new UsageEntity();
//        utilitaire.setName("Utilitaire");
//        usageRepository.save(utilitaire);
//
//        VehicleEntity veh10 = new VehicleEntity();
//        veh10.setUsage(usageRepository.getById(1));
//        veh10.setBrand(brandRepository.getById(1));
//        veh10.setModel("Talisman");
//        vehiculeRepository.save(veh10);


    }




}
