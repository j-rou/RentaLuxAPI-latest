package technobel.jro.RentaLuxAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import technobel.jro.RentaLuxAPI.models.entity.ProfileEntity;

import java.util.List;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository <ProfileEntity,Integer> {

    Optional<ProfileEntity> findByUsername(String username);

}
