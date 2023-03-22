package com.example.serviceplazoleta.domain.api;

import com.example.serviceplazoleta.domain.model.PlatoModel;

import java.util.List;

public interface IPlatoServicePort {

    PlatoModel guardarPlato(PlatoModel platoModel);

    List<PlatoModel> listarPlatos();

    void actualizarPlato(PlatoModel platoModel);

//    PlatoModel buscarPlatoId(Long idPlato);
    PlatoModel buscarPlatoId(Long idPlato);
}

