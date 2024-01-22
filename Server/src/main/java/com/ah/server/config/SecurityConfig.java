package com.ah.server.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // Désactiver CSRF pour les API
                .authorizeRequests()
                .antMatchers("/api/public/**").permitAll() // Permettre l'accès à certains endpoints sans authentification
                .anyRequest().authenticated() // Tous les autres endpoints nécessitent une authentification
                .and()
                .httpBasic(); // Utiliser l'authentification HTTP Basic (pour cet exemple)
    }

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

