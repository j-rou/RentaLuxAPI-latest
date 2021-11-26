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

    private int profileId;
    private int vehiculeId;
    private int dropSiteId;

    private Date startDate;
    private Date endDate;

    private boolean upclassable;
    private int upClassVehiculeId;

    private String payementStatus;
    private String invoiceAccount;


}
