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
@Table(name="hero")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class HeroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private ClanEntity clan;

    @ManyToOne
    private HeroClassEntity heroClass;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<SkillEntity> skills;


}