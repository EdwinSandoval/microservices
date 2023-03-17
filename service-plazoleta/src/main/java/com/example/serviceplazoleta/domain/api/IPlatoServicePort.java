package com.example.serviceplazoleta.domain.api;

import com.example.serviceplazoleta.domain.model.PlatoModel;

import java.util.List;

public interface IPlatoServicePort {

    void guardarPlato(PlatoModel platoModel);

    List<PlatoModel> listarPlatos();
}
