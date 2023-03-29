package com.pragma.usuarioservice.infraestructure.out.jpa.adapter;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.infraestructure.out.jpa.mapper.IUserEntityMapper;
import com.pragma.usuarioservice.infraestructure.out.jpa.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class UserJpaAdapterTest {
    @InjectMocks
    UserJpaAdapter userJpaAdapter;

    @Mock
    IUserRepository userRepository;

    IUserEntityMapper userEntityMapper;

    @Test
    void debeGuardarUnUsuario() {
        RolModel rolModel=new RolModel();
        rolModel.setId(1L);
        rolModel.setNombre("ADMINISTRADOR");
        rolModel.setDescripcion("CREAR PROPIETARIO");

        UsuarioModel esperado=new UsuarioModel();
        esperado.setId(1L);
        esperado.setNombre("Edwin");
        esperado.setApellido("Sandoval");
        esperado.setCelular("+696588");
        esperado.setEmail("edwin@gmail.com");
        esperado.setPassword("123");
        esperado.setDni("78451263");
        esperado.setRol(rolModel);

        UsuarioModel usuarioModel=new UsuarioModel();
        usuarioModel.setNombre("Edwin");
        usuarioModel.setApellido("Sandoval");
        usuarioModel.setCelular("+696588");
        usuarioModel.setEmail("edwin@gmail.com");
        usuarioModel.setPassword("123");
        usuarioModel.setDni("78451263");
        usuarioModel.setRol(rolModel);

        when(userRepository.findByEmail(anyString()))
                .thenReturn(Optional.empty());

        userJpaAdapter.saveUsers(usuarioModel);

//        verify(userRepository.save(any(UsuarioModel.class)));

    }

    @Test
    void getAllUsers() {
    }

    @Test
    void getUserId() {
    }

    @Test
    void getEmail(){

    }
}