package technobel.jro.RentaLuxAPI.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import technobel.jro.RentaLuxAPI.models.entity.LocationEntity;

import java.util.List;

public interface LocationRepository extends JpaRepository <LocationEntity,Integer> {

    List<LocationEntity> findByVehiculeId(int id);

}
