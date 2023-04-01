package com.pragma.usuarioservice.infraestructure.out.jpa.adapter;

import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.domain.spi.IRolPersistencePort;
import com.pragma.usuarioservice.domain.spi.IUsuarioPersistencePort;
import com.pragma.usuarioservice.domain.usecase.UsersUseCase;
import com.pragma.usuarioservice.infraestructure.out.jpa.adapter.builders.RoleModelBuilder;
import com.pragma.usuarioservice.infraestructure.out.jpa.adapter.builders.UsuarioModelBuilder;
import com.pragma.usuarioservice.infraestructure.security.impl.IEncryptPassword;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
//import static org.mockito.Mockito.verify;


class RolJpaAdapterTest {

    @Mock
    private  IUsuarioPersistencePort usuarioPersistencePort;//elemento que va a implementar nuestro puerto de persistencia
    @Mock
    private  IRolPersistencePort rolPersistencePort;
    @Mock
    private  IEncryptPassword encryptPassword;

    private UsersUseCase useCase;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        useCase = new UsersUseCase(usuarioPersistencePort,rolPersistencePort,encryptPassword);
    }

    @Test
    void mustSaveARols() {

        UsuarioModel usuario = UsuarioModelBuilder.getUsurioModel();
        UsuarioModel expectedUser = UsuarioModelBuilder.getUsurioModelPasswordEncrypt();
        Long idRol = 1L;

        Mockito.when(encryptPassword.encryptPassword(usuario.getPassword())).thenReturn("qwerty");
        Mockito.when(rolPersistencePort.getRoleById(idRol)).thenReturn(RoleModelBuilder.getRolModel());
        Mockito.when(usuarioPersistencePort.saveUsers(any(UsuarioModel.class))).thenReturn(usuario);

        useCase.saveUsers(usuario,idRol);

        verify(rolPersistencePort,times(1)).getRoleById(idRol);
        verify(usuarioPersistencePort,times(1)).saveUsers(any(UsuarioModel.class));


        /*
        //Dao todo lo q se tiene de insumo
        //yo como usuario hago la solicitud de guardar un pokemon
        RolModel rolEsperado=new RolModel();
        rolEsperado.setId(1L);
        rolEsperado.setNombre("administardor");
        rolEsperado.setDescripcion("crea restaurante");

        RolModel rolModel=new RolModel();
        rolModel.setId(1L);
        rolModel.setNombre("administardor");
        rolModel.setDescripcion("crea restaurante");

        //when se usa cuando sucede algo
        //le envio los datos correctamente
        when(rolEntityMapper.toRolModel(any())).thenReturn(rolEsperado);
        rolJpaAdapter.saveRols(rolModel);
        verify(rolRepository.save(any(RolEntity.class)));

         */
    }


}