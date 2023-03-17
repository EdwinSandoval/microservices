package com.example.serviceplazoleta.domain.spi;

import com.example.serviceplazoleta.domain.model.PlatoModel;

import java.util.List;

public interface IPlatoPersistencePort {


    PlatoModel guardarPlato(PlatoModel platoModel);

    List<PlatoModel> listarPlatos();
}
