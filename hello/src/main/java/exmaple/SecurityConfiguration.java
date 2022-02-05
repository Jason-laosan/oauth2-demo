package exmaple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author: laosan
 * Date: 2022/2/3
 * Time: 21:46
 * Describe:
 */
@EnableWebSecurity
@Configuration
public class SecurityConfiguration {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
                .httpBasic(withDefaults())
                .formLogin(withDefaults());
        return httpSecurity.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails build = User.withDefaultPasswordEncoder()
                .username("user")
                .password("123456")
                .roles("admin")
                .build();
        return new InMemoryUserDetailsManager(build);
    }
}
