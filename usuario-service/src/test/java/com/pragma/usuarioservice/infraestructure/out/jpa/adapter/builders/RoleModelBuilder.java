package com.pragma.usuarioservice.infraestructure.out.jpa.adapter.builders;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.domain.model.UsuarioModel;

public class RoleModelBuilder {

    public static  RolModel getRolModel(){
        RolModel rolModel = new RolModel();
        rolModel.setId(1L);
        rolModel.setNombre("administrador");
        rolModel.setDescripcion("descripcion");

        return rolModel;
    }

}
