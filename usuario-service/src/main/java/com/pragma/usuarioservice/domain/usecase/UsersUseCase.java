package com.pragma.usuarioservice.domain.usecase;

import com.pragma.usuarioservice.domain.api.IUsuarioServicePort;
import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.domain.spi.IRolPersistencePort;
import com.pragma.usuarioservice.domain.spi.IUsuarioPersistencePort;
import com.pragma.usuarioservice.infraestructure.security.IEncryptPassword;

import java.util.List;

public class UsersUseCase  implements IUsuarioServicePort {
    private final IUsuarioPersistencePort usuarioPersistencePort;//elemento que va a implementar nuestro puerto de persistencia
    private final IRolPersistencePort rolPersistencePort;
    private final IEncryptPassword encryptPassword;

    public UsersUseCase(IUsuarioPersistencePort usuarioPersistencePort, IRolPersistencePort rolPersistencePort, IEncryptPassword encryptPassword) {
        this.usuarioPersistencePort = usuarioPersistencePort;
        this.rolPersistencePort = rolPersistencePort;
        this.encryptPassword = encryptPassword;

    }

    @Override
    public UsuarioModel saveUsers(UsuarioModel usuarioModel,Long idRol) {
        String encoderPassword=encryptPassword.encryptPassword(usuarioModel.getPassword());
        usuarioModel.setPassword(encoderPassword);
        usuarioModel.setRol(rolPersistencePort.getRoleById(idRol));
        usuarioModel.setId(-1L);
        return  usuarioPersistencePort.saveUsers(usuarioModel);
    }

    @Override
    public List<UsuarioModel> getAllUsers() {
        return usuarioPersistencePort.getAllUsers();
    }


    @Override
    public UsuarioModel getUserId(Long id) {
        return usuarioPersistencePort.getUserId(id);
    }




//
//    @Override
//    public boolean deleteUser(Long userId) {
//        return getUserId(userId).map(user->{
//            usuarioPersistencePort.deleteUser(userId);
//            return true;
//        }).orElse(false);
//        if (getUserId(userId).isPresent()){
//            usuarioPersistencePort.deleteUser(userId);
//            return true;
//        }else return false;
//    }


}
