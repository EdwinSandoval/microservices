package com.example.serviceplazoleta.application.handler.impl;

import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarEstadoPlatoRequest;
import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarPlatoRequest;
import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.Plato.BuscarPlatoIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.Plato.PlatoPaginadoResponseDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.application.handler.IPlatoHandler;
import com.example.serviceplazoleta.application.mapper.IPlatoPaginadoDtoMapper;
import com.example.serviceplazoleta.application.mapper.IPlatoRequestMapper;
import com.example.serviceplazoleta.application.mapper.IPlatoResponseMapper;
import com.example.serviceplazoleta.application.mapper.IRestauranteRequestMapper;
import com.example.serviceplazoleta.domain.api.IPlatoServicePort;
import com.example.serviceplazoleta.domain.api.IRestauranteServicePort;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import com.example.serviceplazoleta.infraestructure.out.jpa.mapper.IRestauranteEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor//automaticamnete genera constructor a lo que hallamos definido como final
@Service//toma la clase como un bean y ya se puede inyectar
@Transactional
public class PlatoHandler  implements IPlatoHandler {

    private final IPlatoServicePort platoServicePort;
    private final IPlatoRequestMapper platoRequestMapper;
    private final IPlatoResponseMapper platoResponseMapper;
//    private final IPlatoPaginadoDtoMapper iPlatoPaginadoDtoMapper;


    @Override
    public void guardarPlato(Long idProp,PlatoRequestDto platoRequestDto) {
        PlatoModel platoModel = platoRequestMapper.toPlato(platoRequestDto);
//        platoModel.setActivo(true);
        platoResponseMapper.toResponse(platoServicePort.guardarPlato(idProp,platoModel));
    }

    @Override
    public List<PlatoResponseDto> listarPlatos() {
        return platoResponseMapper.toResponseList(platoServicePort.listarPlatos());
    }

    @Override
    public void actualizarPlato(ActualizarPlatoRequest actualizarPlatoRequest,Long idProp) {

        PlatoModel platoModel=platoRequestMapper.toActualizarPlato(actualizarPlatoRequest);
        platoServicePort.actualizarPlato(platoModel,idProp);

    }

    @Override
    public void actualizarEstadoPlato(ActualizarEstadoPlatoRequest estado,Long idProp) {
        PlatoModel platoModel=platoRequestMapper.toActualizarEstadoPlato(estado);
        platoServicePort.actualizarEstadoPlato(platoModel,idProp);
    }


    @Override
    public List<PlatoPaginadoResponseDto> listarPlatosPaginados(Long idRest, Integer numeroPaginas, Integer elementoPorPagina) {
        return platoResponseMapper.toPlatoPaginado(platoServicePort
                .listarPlatosPaginados(idRest,numeroPaginas,
                        elementoPorPagina));
    }

    @Override
    public BuscarPlatoIdResponseDto buscarPlatoId(Long idPlato) {
        PlatoModel platoModel=platoServicePort.buscarPlatoId(idPlato);
        return platoResponseMapper.toResponseId(platoModel);
    }
}
