package technobel.jro.fenrirAPI.models.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class ClanDTO {

    @NotBlank
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String bio;



}
