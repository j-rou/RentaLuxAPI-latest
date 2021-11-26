package technobel.jro.RentaLuxAPI.models.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Builder
public class LocationDTO {

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
