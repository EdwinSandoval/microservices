package com.pragma.usuarioservice.infraestructure.out.jpa.adapter.Usecase;

import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.domain.spi.IRolPersistencePort;
import com.pragma.usuarioservice.domain.spi.IUsuarioPersistencePort;
import com.pragma.usuarioservice.domain.usecase.UsersUseCase;
import com.pragma.usuarioservice.infraestructure.out.jpa.adapter.builders.UsuarioModelBuilder;
import com.pragma.usuarioservice.infraestructure.security.impl.IEncryptPassword;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UserUseCaseTest {

    @InjectMocks
    UsersUseCase usersUseCase;
    @Mock
    private  IUsuarioPersistencePort usuarioPersistencePort;
    @Mock
    private  IRolPersistencePort rolPersistencePort;
    @Mock
    private  IEncryptPassword encryptPassword;

    @Test
    void saveAUser(){
        UsuarioModel usuario = UsuarioModelBuilder.getUsurioModel();
        UsuarioModel expectedUser = UsuarioModelBuilder.getUsurioModelPasswordEncrypt();

//        when(repo)

    }

}
