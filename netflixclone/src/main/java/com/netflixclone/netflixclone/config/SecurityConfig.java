package com.netflixclone.netflixclone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration   // indicates that this class contains configuration beans and settings for the application, and it will be processed by Spring to set up the application context
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() { // define a bean for password encoding, which will be used to securely hash user passwords before storing them in the database
        return new BCryptPasswordEncoder(); // return an instance of BCryptPasswordEncoder for secure password hashing

    }

    // 🔓 Allow APIs
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()  // allow register
                .anyRequest().permitAll()                    // allow all for now
            );

        return http.build();
    }
}
