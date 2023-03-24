package com.example.serviceplazoleta.security;

import com.example.serviceplazoleta.domain.model.Usuario.UsuarioModel;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.Usuario.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
//        UserDetails user= User
//                .withUsername("user")
//                .password(passwordEncoder.encode("123456"))
//                .roles("USER")
//                .build();
//        UserDetails admin=User
//                .withUsername("admin")
//                .password(passwordEncoder.encode("123456"))
//                .roles("USER","ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user,admin);
//    }

//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Autowired
    private IUsuarioRepository iUsuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioModel usuarioModel=iUsuarioRepository
                .findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("El usuario con email "+email+" no existe"));
        return new UserDetailsImpl(usuarioModel);
    }
}
