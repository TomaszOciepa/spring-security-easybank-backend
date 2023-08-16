package com.tomasz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("myAccount", "/myBalance", "/myCards", "/myLoans").authenticated()
                        .requestMatchers("/notices", "/contact").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain) http.build();
    }

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder().encode("12345"))
                .roles("ROLE_ADMIN")
                .build();

        UserDetails user = User
                .withUsername("user")
                .password(passwordEncoder().encode("12345"))
                .roles("ROLE_USER")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
