package technobel.jro.RentaLuxAPI.models.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="vehicule")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class VehiculeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String model;
    private String category;


}
