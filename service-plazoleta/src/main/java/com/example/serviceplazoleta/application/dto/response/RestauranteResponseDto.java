package com.example.serviceplazoleta.application.dto.response;

import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestauranteResponseDto {

    private Long idRestaurante;

    private String nombre;

    private String direccion;

    private String telefono;

    private String urlLogo;

    private String nit;

    private Long idPropietario;
//    private RestauranteModel restauranteModel;
//    private UserResponseDto userResponseDto;

}
