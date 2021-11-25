package technobel.jro.RentaLuxAPI.models.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="profile")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProfileEntity {

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
