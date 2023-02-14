package es.nhs.alquilerhardware.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig
{

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception
    {
        //http://acodigo.blogspot.com/2017/05/tutorial-spring-security-basico.html
        http
                .authorizeRequests()
                .requestMatchers("/", "", "/js/**", "/css/**").permitAll()
                .requestMatchers("/aulas/", "/aula/", "/eliminarReserva/").hasRole("USER_CARRITO_1PLANTA")
                .requestMatchers("/**").hasRole("ADMIN")
                .and().formLogin()
                .and().logout();
        return http.build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService()
    {
        return new InMemoryUserDetailsManager(
                User.withUsername("Administrador").password("{noop}demo").roles("ADMIN").build(),
                User.withUsername("User1").password("{noop}demo").roles("USER_CARRITO_1PLANTA").build(),
                User.withUsername("User2").password("{noop}demo").roles("USER_CARRITO_2PLANTA").build()
        );
    }


}
