package com.pragma.usuarioservice.infraestructure.out.jpa.adapter;

import com.pragma.usuarioservice.domain.model.RolModel;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.RolEntity;
import com.pragma.usuarioservice.infraestructure.out.jpa.mapper.IRolEntityMapper;
import com.pragma.usuarioservice.infraestructure.out.jpa.repository.IRolRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class RolJpaAdapterTest {

    @InjectMocks
    RolJpaAdapter rolJpaAdapter;

    @Mock
    IRolRepository rolRepository;

    @Mock
    IRolEntityMapper rolEntityMapper;

    @Test
    void mustSaveARols() {
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
    }

    @Test
    void getAllRols() {
    }
}