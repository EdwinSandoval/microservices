package com.pragma.usuarioservice.domain.spi;

import com.pragma.usuarioservice.domain.model.RolModel;

import java.util.List;

public interface IRolPersistencePort {
    RolModel getRoleById(Long id);
    void saveRols(RolModel rolModel);

    List<RolModel> getAllRols();


}
