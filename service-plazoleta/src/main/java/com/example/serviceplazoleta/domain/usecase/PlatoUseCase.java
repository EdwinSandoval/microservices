package com.example.serviceplazoleta.domain.usecase;

import com.example.serviceplazoleta.domain.api.IPlatoServicePort;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.domain.spi.IPlatoPersistencePort;

import java.util.List;

public class PlatoUseCase implements IPlatoServicePort {

    private final IPlatoPersistencePort platoPersistencePort;

    public PlatoUseCase(IPlatoPersistencePort platoPersistencePort) {
        this.platoPersistencePort = platoPersistencePort;
    }

    @Override
    public PlatoModel guardarPlato(PlatoModel platoModel) {
        return  platoPersistencePort.guardarPlato(platoModel);
    }

    @Override
    public List<PlatoModel> listarPlatos() {

        return platoPersistencePort.listarPlatos();
    }

    @Override
    public void actualizarPlato(PlatoModel platoModel) {
        platoPersistencePort.actualizarPlato(platoModel);
    }

    @Override
    public PlatoModel buscarPlatoId(Long idPlato) {

        return platoPersistencePort.buscarPlatoId(idPlato);
    }


}
