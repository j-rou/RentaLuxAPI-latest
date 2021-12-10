package technobel.jro.RentaLuxAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter  {


    private final UserDetailsService service;
    public WebSecurityConfig(UserDetailsService service) {
        this.service = service;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService( service );
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers()
                .frameOptions()
                .disable();
        // pas de cookies
        http.sessionManagement().sessionCreationPolicy( SessionCreationPolicy.STATELESS );
        http.authorizeRequests()
                .anyRequest().permitAll();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable();
//
//        http.httpBasic();
//
//        http.authorizeRequests()
////                .antMatchers(HttpMethod.POST,"/**").hasAuthority("ADMIN")
////                .antMatchers(HttpMethod.DELETE,"/**").hasAuthority("ADMIN")
////                .antMatchers(HttpMethod.PUT,"/**").hasAuthority("ADMIN")
////                .antMatchers(HttpMethod.GET,"/**").hasAuthority("USER")
//                .anyRequest().permitAll();
//
//        }

}
