package technobel.jro.fenrirAPI.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    private final PasswordEncoder encoder;

    public WebSecurityConfig(PasswordEncoder encoder) {
        this.encoder = encoder;
    }
   */

    private final UserDetailsService service;

    public WebSecurityConfig(UserDetailsService service) {
        this.service = service;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    /*
        auth.inMemoryAuthentication()
                .withUser("admin").password(encoder.encode("pass")).authorities("ADMIN","USER")
                .and()
                .withUser("user").password(encoder.encode("pass")).authorities("USER");
    */
        auth.userDetailsService( service );

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        http.httpBasic();

        http.authorizeRequests()
                .antMatchers(HttpMethod.POST,"/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT,"/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/**").hasAuthority("USER")
                .anyRequest().permitAll();

        /*  IDEM
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/xxx/**").hasAuthority("USER")
                .antMatchers("/xxx/**").hasAuthority("ADMIN")
                .anyRequest().permitAll();
        */


    }
}
