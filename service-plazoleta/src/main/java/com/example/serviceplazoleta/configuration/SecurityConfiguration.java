package com.example.serviceplazoleta.configuration;

import com.example.serviceplazoleta.application.dto.response.User.RolResponseDto;
import com.example.serviceplazoleta.configuration.auth.Rol;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.serviceplazoleta.configuration.auth.Rol.*;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(STATELESS);
        http.authorizeHttpRequests().antMatchers(POST,
                "/api/v1/user/guardarPropietario",
                          "/api/v1/restaurante/guardar")
                .hasAuthority(ADMINISTRADOR.name());
        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/user/guardarCliente").permitAll();
        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/user/guardarEmpleado").hasAuthority(PROPIETARIO.name());
        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/plato/**").hasAuthority(PROPIETARIO.name());
//        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/plato/guardar/{idProp}").hasAuthority(PROPIETARIO.name());
//        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/plato/actualizar/{idProp}").hasAuthority(PROPIETARIO.name());
//        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/plato/actualizarEstado/{idProp}").hasAuthority(PROPIETARIO.name());


        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/restaurante/**").permitAll();
        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/categoria/**").permitAll();
//        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/restaurante/guardar").hasAuthority(propietario.name());
        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/user/**").permitAll();//.hasAuthority(administrador.name());
        http.authorizeHttpRequests().antMatchers(POST,"/api/v1/auth/**").permitAll();


        http.authorizeHttpRequests().anyRequest().authenticated();
        http.addFilterBefore(jwtAuthFilter,UsernamePasswordAuthenticationFilter.class);

//                .authorizeHttpRequests()
//
//                .antMatchers("/api/v1/auth/**").permitAll()
//                .antMatchers("/api/v1/user/**","/api/v1/restaurante/**").permitAll()
//                .antMatchers("/api/v1/user/guardarPropietario").hasAuthority(administrador.name())
////                .antMatchers("/api/v1/user/").hasAuthority("ADMINISTRADOR")
//
//                .anyRequest()
//                .authenticated()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

         return http.build();
    }
}
