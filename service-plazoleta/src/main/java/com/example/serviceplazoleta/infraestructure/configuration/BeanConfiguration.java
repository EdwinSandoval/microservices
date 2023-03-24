package com.example.serviceplazoleta.infraestructure.configuration;

import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.configuration.auth.Details.DetailsUser;
import com.example.serviceplazoleta.configuration.auth.Details.IDetailsUserMapper;
import com.example.serviceplazoleta.domain.api.ICategoriaServicePort;
import com.example.serviceplazoleta.domain.api.IPedidoServicePort;
import com.example.serviceplazoleta.domain.api.IPlatoServicePort;
import com.example.serviceplazoleta.domain.api.IRestauranteServicePort;
import com.example.serviceplazoleta.domain.spi.ICategoriaPersistencePort;
import com.example.serviceplazoleta.domain.spi.IPedidoPersistencePort;
import com.example.serviceplazoleta.domain.spi.IPlatoPersistencePort;
import com.example.serviceplazoleta.domain.spi.IRestaurantePersistencePort;
import com.example.serviceplazoleta.domain.usecase.CategoriaUseCase;
import com.example.serviceplazoleta.domain.usecase.PedidoUseCase;
import com.example.serviceplazoleta.domain.usecase.PlatoUseCase;
import com.example.serviceplazoleta.domain.usecase.RestauranteUseCase;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.input.rest.RestauranteRestController;
import com.example.serviceplazoleta.infraestructure.out.jpa.adapter.CategoriaJpaAdapter;
import com.example.serviceplazoleta.infraestructure.out.jpa.adapter.PedidoJpaAdapter;
import com.example.serviceplazoleta.infraestructure.out.jpa.adapter.PlatoJpaAdapter;
import com.example.serviceplazoleta.infraestructure.out.jpa.adapter.RestauranteJpaAdapter;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.ICategoriaEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPedidoEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IPlatoEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IRestauranteEntityMapper;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.ICategoriaRepository;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IPedidoRepository;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IPlatoRepository;
import com.example.serviceplazoleta.infraestructure.out.jpa.repository.IRestauranteRepository;
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

        return new PedidoUseCase(pedidoPersistencePort());
    }

    //****************************************************************************

    private final IPlatoRepository platoRepository;
    private final IPlatoEntityMapper platoEntityMapper;
    private final IUserFeign iUserFeign;
//    private final RestauranteRestController restauranteRestController;
    @Bean
    public IPlatoPersistencePort platoPersistencePort() {

        return new PlatoJpaAdapter(platoRepository, platoEntityMapper,iUserFeign);
    }

    @Bean
    public IPlatoServicePort platoServicePort() {

        return new PlatoUseCase(platoPersistencePort());
    }

    //****************************************************************************

    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;

    @Bean
    public IRestaurantePersistencePort restaurantePersistencePort() {

        return new RestauranteJpaAdapter(restauranteRepository, restauranteEntityMapper,iUserFeign);
    }

    @Bean
    public IRestauranteServicePort restauranteServicePort() {

        return new RestauranteUseCase(restaurantePersistencePort());
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
