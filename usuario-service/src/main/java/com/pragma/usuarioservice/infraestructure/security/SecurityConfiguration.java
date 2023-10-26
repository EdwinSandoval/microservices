package com.pragma.usuarioservice.infraestructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.pragma.usuarioservice.infraestructure.security.auth.Rol.ADMINISTRADOR;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeHttpRequests().antMatchers(POST,
                "/api/v1/user/guardarPropietario").hasAuthority(ADMINISTRADOR.name());

        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/user/guardarCliente").permitAll();
        http.authorizeHttpRequests().antMatchers(GET,"/api/v1/user/listar").hasAuthority(ADMINISTRADOR.name());
        http.authorizeHttpRequests().antMatchers(GET,"/api/v1/user/**").permitAll();//.hasAuthority(administrador.name());
        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/user/guardarAdmin").hasAuthority(ADMINISTRADOR.name());//.hasAuthority(administrador.name());
        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/auth/**","swagger-ui/**").permitAll();
        http.authorizeHttpRequests().antMatchers(GET,"/swagger-ui/**", "/swagger-resources/**", "/api/v1/user/client/**",
                "/v3/api-docs/**", "/v2/api-docs/**","/configuration/**").permitAll();

        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }
}
