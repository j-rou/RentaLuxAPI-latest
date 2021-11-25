package technobel.jro.RentaLuxAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import technobel.jro.RentaLuxAPI.models.entity.ProfileEntity;

public interface ProfileRepository extends JpaRepository <ProfileEntity,Integer> {



}
