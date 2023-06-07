package gic.i4b.gicCafe.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Order(1)
public class EmployeeSecurityConfig {

    @Autowired
    CustomSuccessHandler customSuccessHandler;
    
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserInfoUserDetailsService();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {

        http.authorizeHttpRequests()
            .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
            .permitAll();
        http
        .authorizeHttpRequests(authorize -> authorize
              .requestMatchers(new AntPathRequestMatcher("/employee/**")).hasAuthority("CASHIER")
              .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/employee/login")
            .successHandler(customSuccessHandler)
            // .failureUrl("/pagenotfound")
            .permitAll()
        )
        .logout(logout -> logout
            .permitAll()
        )
        .httpBasic();

        
        return http.csrf().disable().build();
        
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean 
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}