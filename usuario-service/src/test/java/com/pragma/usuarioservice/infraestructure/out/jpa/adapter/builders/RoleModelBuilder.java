package com.pragma.usuarioservice.infraestructure.out.jpa.adapter.builders;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.domain.model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RoleModelBuilder {

    public static  RolModel getRolModel(){
        RolModel rolModel = new RolModel();
        rolModel.setId(1L);
        rolModel.setNombre("administrador");
        rolModel.setDescripcion("descripcion");

        return rolModel;
    }

    public static List<RolModel> getAll(){
        RolModel re=new RolModel(1L,"nada","fefe");
        RolModel re1=new RolModel(2L,"admin","fefhgt");
        RolModel re2=new RolModel(3L,"nada","hfef");
        List<RolModel> listaRols=new ArrayList<>();
        Stream.of(re,re1,re2)
                .forEach(listaRols::add);
        return listaRols;
    }
}
