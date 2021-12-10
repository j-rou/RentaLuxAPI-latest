package technobel.jro.RentaLuxAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import technobel.jro.RentaLuxAPI.models.entity.UsageEntity;

public interface UsageRepository extends JpaRepository <UsageEntity,Integer> {



}
