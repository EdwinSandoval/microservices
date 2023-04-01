package com.pragma.usuarioservice.infraestructure.out.jpa.adapter.builders;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.domain.model.UsuarioModel;

public class UsuarioModelBuilder {

    public static UsuarioModel getUsurioModel(){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNombre("Edwin");
        usuarioModel.setApellido("Sandoval");
        usuarioModel.setCelular("89563212");
        usuarioModel.setRol(RoleModelBuilder.getRolModel());
        usuarioModel.setEmail("edwin@gmail.com");
        usuarioModel.setPassword("123456789");
        usuarioModel.setDni("123456");
        usuarioModel.setId(1L);

        return usuarioModel;
    }

    public static UsuarioModel getUsurioModelPasswordEncrypt(){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setNombre("Edwin");
        usuarioModel.setApellido("Sandoval");
        usuarioModel.setCelular("89563212");
        usuarioModel.setRol(RoleModelBuilder.getRolModel());
        usuarioModel.setEmail("edwin@gmail.com");
        usuarioModel.setPassword("qwerty");
        usuarioModel.setDni("123456");
        usuarioModel.setId(1L);

        return usuarioModel;
    }
}
