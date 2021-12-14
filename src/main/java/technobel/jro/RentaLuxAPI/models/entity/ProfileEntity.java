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

    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String firstName;

    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String tel;

    private String tva;
    private int[] rentalsId;


}
