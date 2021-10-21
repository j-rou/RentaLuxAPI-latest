package technobel.jro.fenrirAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import technobel.jro.fenrirAPI.models.entity.ParticipantEntity;

public interface ParticipantRepository extends JpaRepository <ParticipantEntity,Integer> {



}
