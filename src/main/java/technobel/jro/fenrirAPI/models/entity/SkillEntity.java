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
@Table(name="skills")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class SkillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    private int level;

    @ManyToMany(mappedBy = "skills")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<HeroEntity> heroList;

}