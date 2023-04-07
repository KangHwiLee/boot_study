package config;

import javax.servlet.DispatcherType;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	 
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
            .antMatchers("/", "/join" , "/css/**").permitAll()
            .anyRequest().authenticated()
            .antMatchers("/admin").hasRole("ROLE_ADMIN")            //권한별 접속 가능 페이지
            .and()
        .formLogin()
            .loginPage("/wpqkf")
            .permitAll()
            .and()
        .logout()
            .permitAll();
    return http.build();
        // configure HTTP security...
     
    }
     
	
}
