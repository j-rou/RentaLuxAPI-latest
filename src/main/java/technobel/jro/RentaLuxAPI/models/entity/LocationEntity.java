package technobel.jro.RentaLuxAPI.models.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="location")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int profileId;
    @Column(nullable = false)
    private int vehiculeId;
    @Column(nullable = false)
    private int dropSiteId;
    @Column(nullable = false)
    private Date startDate;
    @Column(nullable = false)
    private Date endDate;
    @Column(nullable = false)
    private boolean upclassable;
    @Column(nullable = true)
    private int upClassVehiculeId;
    @Column(nullable = false)
    private String payementStatus;
    @Column(nullable = false)
    private String invoiceAccount;


}
