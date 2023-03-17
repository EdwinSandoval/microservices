package com.pragma.usuarioservice.domain.spi;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.domain.model.UsuarioModel;

import java.util.List;

public interface IRolPersistencePort {
    RolModel saveRols(RolModel rolModel);

    List<RolModel> getAllRols();


}
