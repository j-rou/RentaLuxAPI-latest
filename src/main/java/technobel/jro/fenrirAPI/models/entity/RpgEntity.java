package technobel.jro.fenrirAPI.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="rpg")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class RpgEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private PlotEntity plot;

    private LocalDate startDate;

    private LocalDate endDate;

    private String location;

    private int price;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ParticipantEntity> participantList;






}