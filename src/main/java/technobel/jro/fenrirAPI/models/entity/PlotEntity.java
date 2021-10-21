package technobel.jro.fenrirAPI.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="plot")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class PlotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name",nullable = false)
    private String name;
    @Column(name="description",nullable = false)
    private String description;

    @OneToMany
    private List<RpgEntity> rgpList;


}