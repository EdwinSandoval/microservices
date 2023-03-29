package com.example.serviceplazoleta.domain.api;

import com.example.serviceplazoleta.application.dto.request.Plato.ActualizarEstadoPlatoRequest;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPlatoServicePort {

    PlatoModel guardarPlato(Long idProp,PlatoModel platoModel);

    List<PlatoModel> listarPlatos();

    void actualizarPlato(PlatoModel platoModel,Long idProp);
    void actualizarEstadoPlato(PlatoModel platoModel, Long idProp);
    List<PlatoModel> listarPlatosPaginados(Long idRest, Integer numeroPaginas,
                                           Integer elementoPorPagina);

//    PlatoModel buscarPlatoId(Long idPlato);
    PlatoModel buscarPlatoId(Long idPlato);
}

