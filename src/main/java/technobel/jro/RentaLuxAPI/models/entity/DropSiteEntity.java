package technobel.jro.RentaLuxAPI.models.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="dropsite")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class DropSiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String address;

}
