package com.travelagency.travelagency.Config;

import com.travelagency.travelagency.Service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Autowired
//    private AppUserService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/", "/register", "/user", "/test", "/save", "/profile","/greeting", "/faq", "/about").permitAll()
                    .requestMatchers("/css/**", "/Imgs/**", "/JS/**", "/webjars/**", "/favicon.ico/**", "/unicons/**", "/sw.js/**", "https://unpkg.com/**", "https://unicons.iconscout.com/**", "https://earth.google.com/**").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(form -> form
                    .defaultSuccessUrl("/", true)
            )
            .logout(config -> config.logoutSuccessUrl("/"));
        return http.build();
    }
}