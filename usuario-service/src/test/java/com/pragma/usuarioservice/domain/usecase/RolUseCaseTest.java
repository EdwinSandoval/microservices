package com.pragma.usuarioservice.domain.usecase;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.domain.spi.IRolPersistencePort;
import com.pragma.usuarioservice.infraestructure.out.jpa.adapter.builders.RoleModelBuilder;
import com.pragma.usuarioservice.infraestructure.out.jpa.adapter.builders.UsuarioModelBuilder;
import com.pragma.usuarioservice.infraestructure.security.auth.Rol;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RolUseCaseTest {


    @Mock
    private IRolPersistencePort rolPersistencePort;

    private RolUseCase rolUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        rolUseCase=new RolUseCase(rolPersistencePort);
    }

    @Test
    void saveRol() {
        RolModel rolModel= RoleModelBuilder.getRolModel();
        rolUseCase.saveRol(rolModel);
        verify(rolPersistencePort, times(1)).saveRols(rolModel);
    }

    @Test
    void getAllRols() {
        List<RolModel> expectedUsuarios = RoleModelBuilder.getAll();
        when(rolPersistencePort.getAllRols()).thenReturn(expectedUsuarios);
        List<RolModel> result = rolUseCase.getAllRols();
        Assertions.assertEquals(expectedUsuarios, result);
    }

    @Test
    void getRolId() {
        Long id = 1L;
        RolModel expectedUsuarioModel = RoleModelBuilder.getRolModel();
        when(rolPersistencePort.getRoleById(id)).thenReturn(expectedUsuarioModel);
        RolModel result = rolUseCase.getRolId(id);
        Assertions.assertEquals(expectedUsuarioModel, result);
    }
}