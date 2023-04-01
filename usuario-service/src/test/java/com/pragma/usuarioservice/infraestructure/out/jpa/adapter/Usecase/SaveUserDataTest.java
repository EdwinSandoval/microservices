package com.pragma.usuarioservice.infraestructure.out.jpa.adapter.Usecase;

import com.pragma.usuarioservice.domain.model.UsuarioModel;
import com.pragma.usuarioservice.infraestructure.out.jpa.adapter.builders.RoleModelBuilder;

public class SaveUserDataTest {

    public static UsuarioModel getUsurioModel(){
        UsuarioModel usuarioModel = new UsuarioModel(1L,"Edwin","Sandoval","98653245",
                "edwin@gmail.com","1234","34345434",RoleModelBuilder.getRolModel());
        return usuarioModel;
    }

    public static UsuarioModel getUsurioModelPasswordEncrypt(){
        UsuarioModel usuarioModel = new UsuarioModel();

        usuarioModel.setRol(RoleModelBuilder.getRolModel());
        usuarioModel.setPassword("qwerty");
        usuarioModel.setDni("123456");
        usuarioModel.setId(1L);

        return usuarioModel;
    }
}
