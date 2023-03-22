package com.example.serviceplazoleta.application.handler.impl;

import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarPlatoRequest;
import com.example.serviceplazoleta.application.dto.request.PlatoRequestDto;
import com.example.serviceplazoleta.application.dto.response.Plato.BuscarPlatoIdResponseDto;
import com.example.serviceplazoleta.application.dto.response.PlatoResponseDto;
import com.example.serviceplazoleta.application.handler.IPlatoHandler;
import com.example.serviceplazoleta.application.mapper.IPlatoRequestMapper;
import com.example.serviceplazoleta.application.mapper.IPlatoResponseMapper;
import com.example.serviceplazoleta.domain.api.IPlatoServicePort;
import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import lombok.RequiredArgsConstructor;
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

    @Override
    public PlatoResponseDto guardarPlato(PlatoRequestDto platoRequestDto) {
        PlatoModel platoModel = platoRequestMapper.toPlato(platoRequestDto);
//        platoServicePort.guardarPlato(platoModel);
        return platoResponseMapper.toResponse(platoServicePort.guardarPlato(platoModel));
    }

    @Override
    public List<PlatoResponseDto> listarPlatos() {
        return platoResponseMapper.toResponseList(platoServicePort.listarPlatos());
    }

    @Override
    public void actualizarPlato(ActualizarPlatoRequest actualizarPlatoRequest) {
        PlatoModel platoAntiguo=platoServicePort.buscarPlatoId(actualizarPlatoRequest.getId());
       if (platoAntiguo!=null){
           PlatoModel platoModel=new PlatoModel();

           platoModel.setId(platoAntiguo.getId());
           platoModel.setNombre(platoAntiguo.getNombre());
           platoModel.setPrecio(actualizarPlatoRequest.getPrecio());
           platoModel.setDescripcion(actualizarPlatoRequest.getDescripcion());
           platoModel.setUrlImagen(platoAntiguo.getUrlImagen());
           platoModel.setActivo(platoAntiguo.isActivo());
           platoModel.setCategoria(platoAntiguo.getCategoria());
           platoModel.setRestaurant(platoAntiguo.getRestaurant());



           platoServicePort.actualizarPlato(platoModel);
       }


    }

    @Override
    public BuscarPlatoIdResponseDto buscarPlatoId(Long idPlato) {
        PlatoModel platoModel=platoServicePort.buscarPlatoId(idPlato);
        return platoResponseMapper.toResponseId(platoModel);
    }
}
