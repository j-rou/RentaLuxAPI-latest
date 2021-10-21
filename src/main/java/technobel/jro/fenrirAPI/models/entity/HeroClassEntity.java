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
@Table(name="heroClass")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HeroClassEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<EquipementEntity> availableEquipement;


}