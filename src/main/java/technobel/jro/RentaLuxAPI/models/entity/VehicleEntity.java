package technobel.jro.RentaLuxAPI.models.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="vehicle")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String model;

    @ManyToOne
    @JoinColumn(nullable = false)
    private BrandEntity brand;

    @ManyToOne
    @JoinColumn(nullable = false)
    private UsageEntity usage;



}
