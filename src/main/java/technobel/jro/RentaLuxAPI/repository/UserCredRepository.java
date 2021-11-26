package technobel.jro.RentaLuxAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import technobel.jro.RentaLuxAPI.models.entity.UserCredEntity;

import java.util.Optional;

public interface UserCredRepository extends JpaRepository <UserCredEntity,Integer> {


    Optional<UserCredEntity> findByUsername(String username);



}
