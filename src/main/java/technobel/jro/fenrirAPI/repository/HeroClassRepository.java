package technobel.jro.fenrirAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import technobel.jro.fenrirAPI.models.entity.HeroClassEntity;

public interface HeroClassRepository extends JpaRepository <HeroClassEntity,Integer> {



}
