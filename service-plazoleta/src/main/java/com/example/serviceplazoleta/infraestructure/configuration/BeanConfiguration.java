package com.example.serviceplazoleta.infraestructure.configuration;

import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.configuration.auth.Details.DetailsUser;
import com.example.serviceplazoleta.configuration.auth.Details.IDetailsUserMapper;
import com.example.serviceplazoleta.domain.api.*;
import com.example.serviceplazoleta.domain.spi.*;
import com.example.serviceplazoleta.domain.usecase.*;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.out.jpa.adapter.*;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.*;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
//@ComponentScan("com.example.tuproyecto")
public class BeanConfiguration {

    private final ICategoriaRepository categoriaRepository;
    private final ICategoriaEntityMapper categoriaEntityMapper;


    @Bean
    public ICategoriaPersistencePort categoriaPersistencePort() {

        return new CategoriaJpaAdapter(categoriaRepository, categoriaEntityMapper);
    }
    @Bean
    public ICategoriaServicePort categoriaServicePort() {

        return new CategoriaUseCase(categoriaPersistencePort());
    }

    //****************************************************************************

    private final IPedidoRepository pedidoRepository;
    private final IPedidoEntityMapper pedidoEntityMapper;
    @Bean
    public IPedidoPersistencePort pedidoPersistencePort() {

        return new PedidoJpaAdapter(pedidoRepository, pedidoEntityMapper);
    }

    @Bean
    public IPedidoServicePort pedidoServicePort() {

        return new PedidoUseCase(pedidoPersistencePort(), pedidoEntityMapper, iUserFeign);
    }

    //****************************************************************************

    private final IPedidoPlatoRepository pedidoPlatoRepository;
    private final IPedidoPlatoEntityMapper pedidoPlatoEntityMapper;
    @Bean
    public IPedidoPlatoPersistencePort pedidoPlatoPersistencePort() {

        return new PedidoPlatoJpaAdapter(pedidoPlatoRepository, pedidoPlatoEntityMapper);
    }

    @Bean
    public IPedidoPlatoServicePort pedidoPlatoServicePort() {

        return new PedidoPlatoUseCase(pedidoPlatoPersistencePort(), pedidoPlatoEntityMapper);
    }
    //--------------------------------------------------------------------------
    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;
    private final IUserFeign iUserFeign;
    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;

    //    private final RestauranteRestController restauranteRestController;
    @Bean
    public IPlatoPersistencePort platoPersistencePort() {

        return new PlatoJpaAdapter(platoRepository, categoriaRepository,restauranteRepository,
                platoEntityMapper,categoriaEntityMapper,restauranteEntityMapper,iUserFeign);
    }

    @Bean
    public IPlatoServicePort platoServicePort() {

        return new PlatoUseCase(platoPersistencePort(), categoriaPersistencePort(),restaurantePersistencePort(),
               platoEntityMapper,categoriaEntityMapper,restauranteEntityMapper,iUserFeign);
    }

    //****************************************************************************
//    private final IPedidoPlatoServicePort pedidoPlatoServicePort;
//    private final IPedidoPlatoRequestMapper pedidoPlatoRequestMapper;
//    private final IPedidoPlatoResponseMapper pedidoPlatoResponseMapper;
//
//    @Bean
//    public IPedidoPlatoHandler pedidoPlatoHandler() {
//
//        return new PedidoPlatoHandler()
//    }

//-----------------------------------------------------------------------
    @Bean
    public IRestaurantePersistencePort restaurantePersistencePort() {

        return new RestauranteJpaAdapter(restauranteRepository, restauranteEntityMapper);
    }

    @Bean
    public IRestauranteServicePort restauranteServicePort() {

        return new RestauranteUseCase(restaurantePersistencePort(), restauranteEntityMapper, iUserFeign);
    }

    //-----------------------------------------
//    private final IUserFeign iUserFeign;
    private final IDetailsUserMapper detailsUserMapper;
    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {

        return username -> optionalDetailsUser(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    private Optional<DetailsUser> optionalDetailsUser(String username) {
        UserResponseDto userResponseDto = iUserFeign.obtenerEmail(username);
        userResponseDto = iUserFeign.obtenerEmail(username);

        DetailsUser user = detailsUserMapper.toUser(userResponseDto);
        user.setRol(userResponseDto.getRol().getNombre());
        return Optional.of(user);
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
