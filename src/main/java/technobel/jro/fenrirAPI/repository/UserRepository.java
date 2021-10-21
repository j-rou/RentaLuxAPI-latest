package technobel.jro.fenrirAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import technobel.jro.fenrirAPI.models.entity.UserEntity;

import java.util.Optional;


public interface UserRepository extends JpaRepository <UserEntity,Long> {

    Optional<UserEntity> findByUsername(String username);


}