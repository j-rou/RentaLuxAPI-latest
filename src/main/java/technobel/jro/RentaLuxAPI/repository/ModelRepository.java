package technobel.jro.RentaLuxAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import technobel.jro.RentaLuxAPI.models.entity.VehicleEntity;

public interface ModelRepository extends JpaRepository <VehicleEntity,Integer> {



}
