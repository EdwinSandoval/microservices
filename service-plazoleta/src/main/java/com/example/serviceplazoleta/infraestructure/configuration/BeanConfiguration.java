package com.example.serviceplazoleta.infraestructure.configuration;

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
//import com.example.serviceplazoleta.security.service.LoginService;
import com.example.serviceplazoleta.security.UserDetailsServiceImpl;
import com.example.serviceplazoleta.security.filter.JWTAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

//    private final UserDetailsService userDetailsService;
//    private final JWTAuthorizationFilter jwtAuthorizationFilter;
//    @Bean
//   public UserDetailsService userDetailsService(){
//       return new UserDetailsServiceImpl();
//   }


//    @Bean
//    UserDetailsService userDetailsService() {
//        return new UserDetailsService() {
//            @Override
//            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//                return null;
//            }
//        };
//    }

//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }



//    private final IRestauranteRepository restauranteRepository;
//    private final IRestauranteEntityMapper restauranteEntityMapper;
//    //    private final RestTemplate restTemplate;
////    private final IUserRestaurante iUserRestaurante;
//    @Bean
//    public IUserRestaurante irestaurantePersistencePort() {
//
//        return new RestauranteJpaAdapter(restauranteRepository, restauranteEntityMapper);
//    }
//
//    @Bean
//    public IRestauranteServicePort restauranteServicePort() {
//
//        return new RestauranteUseCase(restaurantePersistencePort());
//    }

}
