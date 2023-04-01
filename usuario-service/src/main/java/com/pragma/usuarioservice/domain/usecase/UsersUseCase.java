package com.pragma.usuarioservice.domain.usecase;

import com.pragma.usuarioservice.domain.api.IUsuarioServicePort;
import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.domain.spi.IRolPersistencePort;
import com.pragma.usuarioservice.domain.spi.IUsuarioPersistencePort;
import com.pragma.usuarioservice.infraestructure.exception.UserAlreadyExistsException;
import com.pragma.usuarioservice.infraestructure.exception.UserNameNotValidateException;
import com.pragma.usuarioservice.infraestructure.security.impl.IEncryptPassword;

import java.util.List;
import java.util.Objects;

public class UsersUseCase  implements IUsuarioServicePort {
    private final IUsuarioPersistencePort usuarioPersistencePort;//elemento que va a implementar nuestro puerto de persistencia
    private final IRolPersistencePort rolPersistencePort;
    private final IEncryptPassword encryptPassword;

    public UsersUseCase(IUsuarioPersistencePort usuarioPersistencePort,IRolPersistencePort rolPersistencePort, IEncryptPassword encryptPassword) {
        this.usuarioPersistencePort = usuarioPersistencePort;
        this.rolPersistencePort = rolPersistencePort;
        this.encryptPassword = encryptPassword;

    }

    @Override
    public UsuarioModel getEmail(String email) {

        return usuarioPersistencePort.getEmail(email);
    }
    @Override
    public void saveUsers(UsuarioModel usuarioModel, Long idRol) {
        if (usuarioModel.validarEmail() && usuarioModel.numeroTelefonoValido() && usuarioModel.dniValidate()){
            String encoderPassword=encryptPassword.encryptPassword(usuarioModel.getPassword());
            usuarioModel.setPassword(encoderPassword);
            usuarioModel.setRol(rolPersistencePort.getRoleById(idRol));
            usuarioPersistencePort.saveUsers(usuarioModel);
        }else{
            throw new UserNameNotValidateException("Usuario invalido");
        }

    }

    @Override
    public List<UsuarioModel> getAllUsers() {
        return usuarioPersistencePort.getAllUsers();
    }

    @Override
    public UsuarioModel getUserId(Long id) {
        return usuarioPersistencePort.getUserId(id);
    }
}
