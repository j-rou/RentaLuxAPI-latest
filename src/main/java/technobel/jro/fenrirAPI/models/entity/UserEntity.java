package technobel.jro.fenrirAPI.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Entity
@Table(name = "utilisateur")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity implements UserDetails  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;


    @ElementCollection (fetch = FetchType.EAGER)
    private List<String> roles;


    @Column(nullable = false)
    private boolean accountNonExpired;
    @Column(nullable = false)
    private boolean accountNonLocked;
    @Column(nullable = false)
    private boolean credentialsNonExpired;
    @Column(nullable = false)
    private boolean enabled;



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                //IDEM CI DESSOUS//.map( role -> new SimpleGrantedAuthority())
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }





}


