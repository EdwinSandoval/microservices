package com.example.serviceplazoleta.security.config;

//import com.example.serviceplazoleta.security.filter.JWTAuthorizationFilter;
import com.example.serviceplazoleta.security.filter.JWTAuthenticationFilter;
import com.example.serviceplazoleta.security.filter.JWTAuthorizationFilter;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)//permite q spring security funcione en nuestro proyecto
@EnableMethodSecurity//habilitar la autorizacion
@RequiredArgsConstructor
public class SeguridadConfig {
    private final JWTAuthorizationFilter jwtAuthorizationFilter;
    private final UserDetailsService userDetailsService;

    private final PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception{
        return http
                .csrf(csrf->csrf.disable())
                .httpBasic(httoBasic->httoBasic.disable())
                .cors(cors->cors.disable())
                .authorizeHttpRequests(auth->
                        auth

                                .antMatchers("/auth/**","/api/v1/restaurante/**").permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(httpSecuritySessionManagementConfigurer ->
                        httpSecuritySessionManagementConfigurer.sessionCreationPolicy(
                                SessionCreationPolicy.STATELESS
                        )
                )
                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
//    private final UserDetailsService userDetailsService;
//    private final JWTAuthorizationFilter jwtAuthorizationFilter;
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception{
//        JWTAuthenticationFilter jwtAuthenticationFilter=new JWTAuthenticationFilter();
//        jwtAuthenticationFilter.setAuthenticationManager(authManager);
//        jwtAuthenticationFilter.setFilterProcessesUrl("/login");
//
//        return http
//            .csrf().disable()
//            .authorizeHttpRequests()
//            .anyRequest()
//            .authenticated()
//            .and()
//            .httpBasic()
//            .and()
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .and()
//                .addFilter(jwtAuthenticationFilter)
//                .addFilterBefore(jwtAuthorizationFilter,UsernamePasswordAuthenticationFilter.class)
//            .build();
//
//
//}
//    @Bean
//    UserDetailsService userDetailsService(){
//    InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
//    manager.createUser(User.withUsername("admin")
//            .password(passwordEncoder().encode("admin"))
//            .roles()
//            .build());
//    return manager;
//}

    @Bean//bean video pragma
    public AuthenticationManager authManager(HttpSecurity http) throws Exception{
        return  http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
      return new BCryptPasswordEncoder();
    }
}
