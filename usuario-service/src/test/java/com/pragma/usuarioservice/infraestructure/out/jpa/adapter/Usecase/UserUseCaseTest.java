package com.pragma.usuarioservice.infraestructure.out.jpa.adapter.Usecase;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.domain.spi.IRolPersistencePort;
import com.pragma.usuarioservice.domain.spi.IUsuarioPersistencePort;
import com.pragma.usuarioservice.domain.usecase.UsersUseCase;
import com.pragma.usuarioservice.infraestructure.exception.UserNameNotValidateException;
import com.pragma.usuarioservice.infraestructure.out.jpa.adapter.builders.UsuarioModelBuilder;
import com.pragma.usuarioservice.infraestructure.security.auth.Rol;
import com.pragma.usuarioservice.infraestructure.security.impl.IEncryptPassword;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@ExtendWith(SpringExtension.class)
public class UserUseCaseTest {
    @Mock
    private IUsuarioPersistencePort usuarioPersistencePort;

    @Mock
    private IRolPersistencePort rolPersistencePort;

    @Mock
    private IEncryptPassword encryptPassword;

    private UsersUseCase usersUseCase;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        usersUseCase = new UsersUseCase(usuarioPersistencePort, rolPersistencePort, encryptPassword);
    }

    @Test
    public void testGetEmail_ValidEmail_Success() {
        // Arrange
        String email = "example@example.com";
        UsuarioModel expectedUsuarioModel = new UsuarioModel();
        when(usuarioPersistencePort.getEmail(email)).thenReturn(expectedUsuarioModel);

        // Act
        UsuarioModel result = usersUseCase.getEmail(email);

        // Assert
        Assertions.assertEquals(expectedUsuarioModel, result);
    }

    @Test
    public void testSaveUsers_ValidUser_Success() {

        // Arrange
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setEmail("example@example.com");
        usuarioModel.setCelular("123456789");
        usuarioModel.setDni("12345678");
        usuarioModel.setPassword("password");

        Long idRol = 1L;

        when(encryptPassword.encryptPassword(usuarioModel.getPassword())).thenReturn("encryptedPassword");
        when(rolPersistencePort.getRoleById(idRol)).thenReturn(new RolModel());

        // Act
        usersUseCase.saveUsers(usuarioModel, idRol);

        // Assert
        verify(usuarioPersistencePort, times(1)).saveUsers(usuarioModel);
    }

    @Test
    public void testSaveUsers_InvalidUser_ThrowsException() {
        // Arrange
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setEmail("example@.ssexample.com");
        usuarioModel.setCelular("123456789-");
        usuarioModel.setDni("1234567re");
        usuarioModel.setPassword("password");
        Long idRol = 1L;

        //para metodos de validaciones sino no se lanza la exception
        boolean telefono=usuarioModel.numeroTelefonoValido();
        boolean email=usuarioModel.validarEmail();
        boolean dni=usuarioModel.dniValidate();

        Assertions.assertFalse(telefono);
        Assertions.assertFalse(email);
        Assertions.assertFalse(dni);
        // Act and Assert
        Assertions.assertThrows(UserNameNotValidateException.class, () -> {
            usersUseCase.saveUsers(usuarioModel, idRol);
        });
    }

    @Test
    public void testGetAllUsers_Success() {
        // Arrange
        List<UsuarioModel> expectedUsuarios = new ArrayList<>();
        when(usuarioPersistencePort.getAllUsers()).thenReturn(expectedUsuarios);
        List<UsuarioModel> result = usersUseCase.getAllUsers();
        Assertions.assertEquals(expectedUsuarios, result);
    }

    @Test
    public void testGetUserId_ValidId_Success() {
        // Arrange
        Long id = 1L;
        UsuarioModel expectedUsuarioModel = UsuarioModelBuilder.getUsurioModel();
        when(usuarioPersistencePort.getUserId(id)).thenReturn(expectedUsuarioModel);
        UsuarioModel result = usersUseCase.getUserId(id);
        Assertions.assertEquals(expectedUsuarioModel, result);
    }
}
