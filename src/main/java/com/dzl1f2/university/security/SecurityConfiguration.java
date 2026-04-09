package com.dzl1f2.university.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/students-page", "/students-page/add", "/h2-console/**").permitAll()
                        .anyRequest().authenticated()
                )

                .formLogin(login -> login
                        .defaultSuccessUrl("/", true)
                )

                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                )

                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**", "/students-page/add")
                )

                .headers(headers -> headers
                        .frameOptions(frame -> frame.disable())
                );

        return http.build();
    }

    @Bean
    public UserDetailsService users(){

        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin123")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }

}