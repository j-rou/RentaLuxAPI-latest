package technobel.jro.RentaLuxAPI.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import technobel.jro.RentaLuxAPI.models.entity.BrandEntity;
import technobel.jro.RentaLuxAPI.models.entity.UsageEntity;
import technobel.jro.RentaLuxAPI.models.entity.VehicleEntity;
import technobel.jro.RentaLuxAPI.repository.*;

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
/*
        UsageEntity superluxe = new UsageEntity();
        superluxe.setName("Touring");
        usageRepository.save(superluxe);

        BrandEntity bmw = new BrandEntity();
        bmw.setName("BMW");
        brandRepository.save(bmw);

        VehicleEntity veh1 = new VehicleEntity();
        veh1.setUsage(superluxe);
        veh1.setBrand(bmw);
        veh1.setModel("X5");
        vehiculeRepository.save(veh1);

        DropSiteEntity drop1 = new DropSiteEntity();
        drop1.setAddress("Avenue d'Houffalize 1 - 6800 Libramont");
        dropSiteRepository.save(drop1);

        DropSiteEntity drop2 = new DropSiteEntity();
        drop2.setAddress("Avenue de Bouillon 1 - 6800 Libramont");
        dropSiteRepository.save(drop2);

        DropSiteEntity drop3 = new DropSiteEntity();
        drop3.setAddress("Rue de la gare 25 - 6840 Bertrix");
        dropSiteRepository.save(drop3);

        DropSiteEntity drop4 = new DropSiteEntity();
        drop4.setAddress("Rue de Grandvoir 14 - 6800 Libramont");
        dropSiteRepository.save(drop4);

        DropSiteEntity drop5 = new DropSiteEntity();
        drop5.setAddress("Rue de Diekirch 38  - 6700 Arlon");
        dropSiteRepository.save(drop5);

        /////////////////////////////////////
        /////////////////////////////////////

        BrandEntity toyota = new BrandEntity();
        toyota.setName("Toyota");
        brandRepository.save(toyota);
        BrandEntity volkswagen = new BrandEntity();
        volkswagen.setName("Volkswagen");
        brandRepository.save(volkswagen);
        BrandEntity peugeot = new BrandEntity();
        peugeot.setName("Peugeot");
        brandRepository.save(peugeot);
        BrandEntity porsche = new BrandEntity();
        porsche.setName("Porsche");
        brandRepository.save(porsche);
        BrandEntity opel = new BrandEntity();
        opel.setName("Opel");
        brandRepository.save(opel);
        BrandEntity fiat = new BrandEntity();
        fiat.setName("Fiat");
        brandRepository.save(fiat);
        BrandEntity ferrari = new BrandEntity();
        ferrari.setName("Ferrari");
        brandRepository.save(ferrari);
        BrandEntity renault = new BrandEntity();
        renault.setName("Renault");
        brandRepository.save(renault);

        /////////////////////////////////////
        /////////////////////////////////////


        UsageEntity utilitaire = new UsageEntity();
        utilitaire.setName("Utilitaire");
        usageRepository.save(utilitaire);
        UsageEntity loisir = new UsageEntity();
        loisir.setName("Loisir");
        usageRepository.save(loisir);
        UsageEntity luxe = new UsageEntity();
        luxe.setName("Luxe");
        usageRepository.save(luxe);
        UsageEntity event = new UsageEntity();
        event.setName("Event");
        usageRepository.save(event);


        /////////////////////////////////////
        /////////////////////////////////////
        
        
        VehicleEntity veh1 = new VehicleEntity();
        veh1.setUsage(utilitaire);
        veh1.setBrand(peugeot);
        veh1.setModel("Boxer");
        vehiculeRepository.save(veh1);

        VehicleEntity veh2 = new VehicleEntity();
        veh2.setUsage(loisir);
        veh2.setBrand(volkswagen);
        veh2.setModel("Golf 3");
        vehiculeRepository.save(veh2);

        VehicleEntity veh3 = new VehicleEntity();
        veh3.setUsage(luxe);
        veh3.setBrand(porsche);
        veh3.setModel("Panamera");
        vehiculeRepository.save(veh3);

        VehicleEntity veh4 = new VehicleEntity();
        veh4.setUsage(utilitaire);
        veh4.setBrand(volkswagen);
        veh4.setModel("Crafter");
        vehiculeRepository.save(veh4);

        VehicleEntity veh5 = new VehicleEntity();
        veh5.setUsage(loisir);
        veh5.setBrand(renault);
        veh5.setModel("Megane");
        vehiculeRepository.save(veh5);

        VehicleEntity veh6 = new VehicleEntity();
        veh6.setUsage(utilitaire);
        veh6.setBrand(renault);
        veh6.setModel("Master");
        vehiculeRepository.save(veh6);

        VehicleEntity veh7 = new VehicleEntity();
        veh7.setUsage(utilitaire);
        veh7.setBrand(renault);
        veh7.setModel("Traffic");
        vehiculeRepository.save(veh7);

        VehicleEntity veh8 = new VehicleEntity();
        veh8.setUsage(loisir);
        veh8.setBrand(renault);
        veh8.setModel("Twingo");
        vehiculeRepository.save(veh8);

        VehicleEntity veh9 = new VehicleEntity();
        veh9.setUsage(loisir);
        veh9.setBrand(renault);
        veh9.setModel("Scenic");
        vehiculeRepository.save(veh9);

        VehicleEntity veh10 = new VehicleEntity();
        veh10.setUsage(loisir);
        veh10.setBrand(renault);
        veh10.setModel("Talisman");
        vehiculeRepository.save(veh10);


        /////////////////////////////////////
        /////////////////////////////////////

        UserCredEntity userCred1 = new UserCredEntity();
        userCred1.setUsername("jorou87");
        userCred1.setEmail("jo@mail.com");
        userCred1.setPassword("1234");
        userCred1.setAccountType("user");
        userCred1.setAccountNonExpired(true);
        userCred1.setAccountNonLocked(true);
        userCred1.setCredentialsNonExpired(true);
        userCred1.setEnabled(true);
        userCred1.setRoles(null);
        userCredRepository.save(userCred1);

        UserCredEntity userCred2 = new UserCredEntity();
        userCred2.setUsername("chabou86");
        userCred2.setEmail("cha@mail.com");
        userCred2.setPassword("1234");
        userCred2.setAccountType("user");
        userCred2.setAccountNonExpired(true);
        userCred2.setAccountNonLocked(true);
        userCred2.setCredentialsNonExpired(true);
        userCred2.setEnabled(true);
        userCred2.setRoles(null);
        userCredRepository.save(userCred2);

        UserCredEntity userCred3 = new UserCredEntity();
        userCred3.setUsername("admin1");
        userCred3.setEmail("admin1@mail.com");
        userCred3.setPassword("root");
        userCred3.setAccountType("admin");
        userCred3.setAccountNonExpired(true);
        userCred3.setAccountNonLocked(true);
        userCred3.setCredentialsNonExpired(true);
        userCred3.setEnabled(true);
        userCred3.setRoles(null);
        userCredRepository.save(userCred2);

        /////////////////////////////////////
        /////////////////////////////////////
        //profileRepository.save();
        // locationRepository.save();


 */


    }




}
