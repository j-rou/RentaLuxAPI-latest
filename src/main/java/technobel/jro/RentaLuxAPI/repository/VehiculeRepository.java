package technobel.jro.RentaLuxAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import technobel.jro.RentaLuxAPI.models.entity.VehiculeEntity;

public interface VehiculeRepository extends JpaRepository <VehiculeEntity,Integer> {



}
