package technobel.jro.RentaLuxAPI.models.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="location")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String address;

    private String firstName;
    private String lastName;
    private String email;

    private String tel;
    private String tva;
    private int[] rentalsId;


}
