package technobel.jro.fenrirAPI.models.form;


import lombok.Data;
import org.springframework.validation.annotation.Validated;
import technobel.jro.fenrirAPI.models.entity.PlotEntity;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Validated
public class RpgForm {

    @NotBlank
    private int id;
    @NotBlank
    private PlotEntity plot;
    @NotBlank
    private LocalDate startDate;
    @NotBlank
    private LocalDate endDate;
    @NotBlank
    private String location;
    @NotBlank
    private int price;

}