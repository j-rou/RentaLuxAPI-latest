package technobel.jro.fenrirAPI.models.dto;

import lombok.Builder;
import lombok.Data;
import technobel.jro.fenrirAPI.models.entity.PlotEntity;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class RpgDTO {

    private int id;

    private PlotEntity plot;

    private LocalDate startDate;

    private LocalDate endDate;

    private String location;

    private int price;


}