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
import org.springframework.web.client.RestTemplate;

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
    @Bean
    public IPlatoPersistencePort platoPersistencePort() {

        return new PlatoJpaAdapter(platoRepository, platoEntityMapper);
    }

    @Bean
    public IPlatoServicePort platoServicePort() {

        return new PlatoUseCase(platoPersistencePort());
    }

    //****************************************************************************

    private final IRestauranteRepository restauranteRepository;
    private final IRestauranteEntityMapper restauranteEntityMapper;
    private final RestTemplate restTemplate;
    @Bean
    public IRestaurantePersistencePort restaurantePersistencePort() {

        return new RestauranteJpaAdapter(restauranteRepository, restauranteEntityMapper,restTemplate);
    }

    @Bean
    public IRestauranteServicePort restauranteServicePort() {

        return new RestauranteUseCase(restaurantePersistencePort());
    }

}
