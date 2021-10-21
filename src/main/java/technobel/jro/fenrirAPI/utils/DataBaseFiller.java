package technobel.jro.fenrirAPI.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import technobel.jro.fenrirAPI.models.entity.*;
import technobel.jro.fenrirAPI.repository.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class DataBaseFiller implements InitializingBean {


    private final ClanRepository clanRepository;
    private final HeroClassRepository heroClassRepository;
    private final HeroRepository heroRepository;
    private final ParticipantRepository participantRepository;
    private final PlotRepository plotRepository;
    private final RpgRepository rpgRepository;
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;
    private final EquipementRepository equipementRepository;

    private final PasswordEncoder encoder;

    public DataBaseFiller(ClanRepository clanRepository,
                          HeroClassRepository heroClassRepository,
                          HeroRepository heroRepository,
                          ParticipantRepository participantRepository,
                          PlotRepository plotRepository,
                          RpgRepository rpgRepository,
                          SkillRepository skillRepository,
                          UserRepository userRepository,
                          EquipementRepository equipementRepository,
                          PasswordEncoder encoder) {
        this.clanRepository = clanRepository;
        this.heroClassRepository = heroClassRepository;
        this.heroRepository = heroRepository;
        this.participantRepository = participantRepository;
        this.plotRepository = plotRepository;
        this.rpgRepository = rpgRepository;
        this.skillRepository = skillRepository;
        this.userRepository = userRepository;
        this.equipementRepository = equipementRepository;
        this.encoder = encoder;
    }


    @Override
    public void afterPropertiesSet() throws Exception {

    /////////////
    // Declaration des comptes user sur la page web. (n'est pas un participant au jeu)
    /////////////
        UserEntity user1 = new UserEntity();
        user1.setUsername("sftjo");
        user1.setPassword(encoder.encode("pass"));
        user1.setRoles(List.of("USER"));
        user1.setEnabled(true);
        user1.setAccountNonLocked(true);
        user1.setAccountNonExpired(true);
        user1.setCredentialsNonExpired(true);
        userRepository.save(user1);

        UserEntity user2 = new UserEntity();
        user2.setUsername("admin");
        user2.setPassword(encoder.encode("root"));
        user2.setRoles(List.of("ADMIN","USER"));
        user2.setEnabled(true);
        user2.setAccountNonLocked(true);
        user2.setAccountNonExpired(true);
        user2.setCredentialsNonExpired(true);
        userRepository.save(user2);

    /////////////
    // Remplissage de la DB avec des infos factices.
    /////////////


    ///////////
        ClanEntity clan1 = new ClanEntity();
        clan1.setName("Loup blanc");
        clan1.setBio("Clan débutant mais comptant de nombreux guérriers");
        clan1 = clanRepository.save(clan1);

        ClanEntity clan2 = new ClanEntity();
        clan2.setName("Hulfhednar");
        clan2.setBio("Clan sur-entrainé et organisé");
        clan2 = clanRepository.save(clan2);

        ClanEntity clan3 = new ClanEntity();
        clan3.setName("Nattvingar");
        clan3.setBio("Clan fortuné et redoutable");
        clan3 = clanRepository.save(clan3);

    ///////////

        EquipementEntity equipement1 = new EquipementEntity();
        equipement1.setName("Epée");
        equipement1.setDescription("Corp a corp - Court - 1 Main");
        equipement1 = equipementRepository.save(equipement1);

        EquipementEntity equipement2 = new EquipementEntity();
        equipement2.setName("Lance");
        equipement2.setDescription("Corp a corp - Long - 2 Mains");
        equipement2 = equipementRepository.save(equipement2);

        EquipementEntity equipement3 = new EquipementEntity();
        equipement3.setName("Arc à flèche");
        equipement3.setDescription("A distance - 2 Mains");
        equipement3 = equipementRepository.save(equipement3);

        EquipementEntity equipement4 = new EquipementEntity();
        equipement4.setName("Bouclier");
        equipement4.setDescription("Protection - 1 Mains");
        equipement4 = equipementRepository.save(equipement4);

    ///////////
        HeroClassEntity heroClass1 = new HeroClassEntity();
        /* peut avoir 1 lance */
        heroClass1.setName("Lancier");
        heroClass1.setAvailableEquipement(List.of(equipement2));
        heroClass1 = heroClassRepository.save(heroClass1);

        HeroClassEntity heroClass2 = new HeroClassEntity();
        /* peut avoir 1 arc */
        heroClass2.setName("Archer");
        heroClass2.setAvailableEquipement(List.of(equipement3));
        heroClass2 = heroClassRepository.save(heroClass2);

        HeroClassEntity heroClass3 = new HeroClassEntity();
        /* peut avoir 2 epées ou 1  epée 1 bouclier */
        heroClass3.setName("Breter");
        heroClass3.setAvailableEquipement(List.of(equipement1,equipement4));
        heroClass3 = heroClassRepository.save(heroClass3);

    ///////////

        SkillEntity voleur = new SkillEntity();
        voleur.setName("Voleur");
        voleur.setDescription("Peut faire les poches.");
        voleur.setLevel(1);
        voleur = skillRepository.save(voleur);

        SkillEntity mineur = new SkillEntity();
        mineur.setName("Mineur");
        mineur.setDescription("Peut miner et traverser les mines.");
        mineur.setLevel(1);
        mineur = skillRepository.save(mineur);

        SkillEntity assassin = new SkillEntity();
        assassin.setName("Assassin");
        assassin.setDescription("Peut égorger.");
        assassin.setLevel(1);
        assassin = skillRepository.save(assassin);

        SkillEntity medecin = new SkillEntity();
        medecin.setName("Medecin");
        medecin.setDescription("Peut guérrir les maladies.");
        medecin.setLevel(1);
        medecin = skillRepository.save(medecin);


    ///////////
        HeroEntity hero1 = new HeroEntity();
        hero1.setName("Ragnar");
        hero1.setHeroClass(heroClassRepository.getById(3));
        hero1.setClan(clanRepository.getById(2));
        hero1.setSkills(List.of(voleur,assassin,medecin));
        hero1 = heroRepository.save(hero1);

        HeroEntity hero2 = new HeroEntity();
        hero2.setName("Jovir");
        hero2.setHeroClass(heroClassRepository.getById(2));
        hero2.setClan(clanRepository.getById(1));
        hero2.setSkills(List.of(assassin));
        hero2 = heroRepository.save(hero2);

        HeroEntity hero3 = new HeroEntity();
        hero3.setName("Jormungandr");
        hero3.setHeroClass(heroClassRepository.getById(1));
        hero3.setClan(clanRepository.getById(3));
        hero3.setSkills(List.of(voleur,assassin));
        hero3 = heroRepository.save(hero3);

        HeroEntity hero4 = new HeroEntity();
        hero4.setName("Floki");
        hero4.setHeroClass(heroClassRepository.getById(3));
        hero4.setClan(clanRepository.getById(1));
        hero4.setSkills(List.of(assassin,medecin));
        hero4 = heroRepository.save(hero4);

    ///////////
        PlotEntity plot1 = new PlotEntity();
        plot1.setName("Yggdrasil");
        plot1.setDescription("La valkyrie a été enfermée par Loki.");
        plot1 = plotRepository.save(plot1);

        PlotEntity plot2 = new PlotEntity();
        plot2.setName("Vengeance de la Valkyrie");
        plot2.setDescription("La valkyrie nous envoie combattre Loki aux portes du Valhalla.");
        plot2 = plotRepository.save(plot2);

    ///////////
        RpgEntity rpg1 = new RpgEntity();
        rpg1.setPlot(plotRepository.getById(1));
        rpg1.setLocation("Vielsalm");
        rpg1.setStartDate(LocalDate.of(2021,10,9));
        rpg1.setEndDate(LocalDate.of(2021,10,12));
        rpg1.setPrice(25);
        rpg1 = rpgRepository.save(rpg1);

        RpgEntity rpg2 = new RpgEntity();
        rpg2.setPlot(plotRepository.getById(2));
        rpg2.setLocation("Bruxelles");
        rpg2.setStartDate(LocalDate.of(2022,10,12));
        rpg2.setEndDate(LocalDate.of(2022,10,15));
        rpg2.setPrice(40);
        rpg2 = rpgRepository.save(rpg2);



    ///////////
        ParticipantEntity participant = new ParticipantEntity();

        participant.setHero(hero1);
        participant.setAddress("Rue du fleuve 15 / 6800 Libramont");
        participant.setFirstName("John");
        participant.setLastName("Wick");
        participant.setHeroClass(hero1.getHeroClass());


        participant = participantRepository.save(participant);

    ///////////




    }




}
