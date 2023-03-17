package com.pragma.usuarioservice.domain.usecase;

import com.pragma.usuarioservice.domain.api.IRolServicePort;
import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.domain.spi.IRolPersistencePort;

import java.util.List;

public class RolUseCase implements IRolServicePort {

    private final IRolPersistencePort rolPersistencePort;

    public RolUseCase(IRolPersistencePort rolPersistencePort) {
        this.rolPersistencePort = rolPersistencePort;
    }

    @Override
    public void saveRol(RolModel rolModel) {
        rolPersistencePort.saveRols(rolModel);
    }

    @Override
    public List<RolModel> getAllRols() {
        return rolPersistencePort.getAllRols();
    }
}
