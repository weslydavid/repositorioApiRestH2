package com.mutualser.apirest.security;

import com.mutualser.apirest.security.filters.JwtAuthenticationFilter;
import com.mutualser.apirest.security.filters.JwtAuthorizationFilter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable() // Deshabilita CSRF
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/user").permitAll() // Permite todos en /api/public
                .antMatchers(HttpMethod.POST,"/api/authenticate").permitAll()
                .anyRequest().authenticated() // Todos los demás endpoints requieren autenticación
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager())) // Añade el filtro de autenticación
                .addFilter(new JwtAuthorizationFilter(authenticationManager())); // Añade el filtro de autorización-
    }
}