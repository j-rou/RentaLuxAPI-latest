package technobel.jro.fenrirAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import technobel.jro.fenrirAPI.models.entity.HeroEntity;

public interface HeroRepository extends JpaRepository <HeroEntity,Integer> {



}
