package technobel.jro.RentaLuxAPI.models.form;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@Validated

public class LocationForm {


    private int id;

    private int profileId;

    private int vehiculeId;

    private int dropSiteId;

    private Date startDate;

    private Date endDate;

    private boolean upclassable;

    private int upClassVehiculeId;
    @NotBlank
    private String payementStatus;
    @NotBlank
    private String invoiceAccount;


}
