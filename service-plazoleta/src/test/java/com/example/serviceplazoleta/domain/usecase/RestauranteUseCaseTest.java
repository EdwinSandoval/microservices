package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.domain.model.RestauranteModel;
import com.example.serviceplazoleta.domain.spi.IRestaurantePersistencePort;
import com.example.serviceplazoleta.infraestructure.client.IUserFeign;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IRestauranteEntityMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
@ExtendWith(MockitoExtension.class)
class RestauranteUseCaseTest {

    @Mock
    private  IRestaurantePersistencePort restaurantePersistencePort;

    private RestauranteUseCase restauranteUseCase;
    @Mock
    private  IRestauranteEntityMapper restauranteEntityMapper;
    @Mock
    private  IUserFeign iUserFeign;

    @BeforeEach
    public void setUtp(){
        this.restauranteUseCase=new RestauranteUseCase(this.restaurantePersistencePort,this.restauranteEntityMapper,this.iUserFeign);
    }

    @Test

    void guardarRestaurante() {
        given(this.restaurantePersistencePort.guardarRestaurante(any())).willReturn(this.guardarMock());
        RestauranteModel restauranteModel= this.restauranteUseCase.guardarRestaurante(this.guardarMock2());
        assertThat(restauranteModel).isNotNull();
    }

    private RestauranteModel guardarMock(){
        return new RestauranteModel(1L,"edwin","lima","123","dedsd","1223",2L);
    }
    private RestauranteModel guardarMock2(){
        return new RestauranteModel(1L,"edwin","lima","123","dedsd","1223",2L);
    }



    @Test
    void listarRestaurantes() {
        given(this.restaurantePersistencePort.listarRestaurantes()).willReturn(this.restauranteModelsMock());
        List<RestauranteModel> restauranteModels= this.restauranteUseCase.listarRestaurantes();
        assertThat(restauranteModels).isNotNull();
    }

    private List<RestauranteModel> restauranteModelsMock(){
        return Arrays.asList(new RestauranteModel(1L,"edwin","lima","123","dedsd","1223",2L));
    }




}