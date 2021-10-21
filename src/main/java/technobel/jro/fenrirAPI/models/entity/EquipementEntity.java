package technobel.jro.fenrirAPI.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="weapon")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class EquipementEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @ManyToMany(mappedBy = "availableEquipement")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<HeroClassEntity> heroClassList;


}