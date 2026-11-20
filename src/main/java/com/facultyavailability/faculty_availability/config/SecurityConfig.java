package com.facultyavailability.faculty_availability.config;
import org.springframework.context.annotation.*; import org.springframework.security.config.annotation.web.builders.HttpSecurity; import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.security.web.SecurityFilterChain;
@Configuration public class SecurityConfig {
 @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
 @Bean SecurityFilterChain filterChain(HttpSecurity http) throws Exception { http.csrf(c->c.disable()).authorizeHttpRequests(a->a.requestMatchers("/","/login","/register","/css/**").permitAll().anyRequest().permitAll()).formLogin(f->f.disable()).logout(l->l.disable()); return http.build(); }
}
