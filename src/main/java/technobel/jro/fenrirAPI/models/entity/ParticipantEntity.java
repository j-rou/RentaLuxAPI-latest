package technobel.jro.fenrirAPI.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "participant")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class ParticipantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String lastName;
    private String firstName;
    private String address;

    @ManyToOne
    private HeroEntity hero;
    @ManyToOne
    private HeroClassEntity heroClass;

    @ManyToMany(mappedBy = "participantList")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<RpgEntity> rpgList;

    @ManyToOne
    private UserEntity userWhoSubscribed;




}


