package com.example.serviceplazoleta.application.dto.response;

import com.example.serviceplazoleta.application.dto.response.User.UserResponseDto;
import com.example.serviceplazoleta.domain.model.RestauranteModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRestaurantResponseDto {
    private RestauranteResponseDto restauranteResponseDto;
    private UserResponseDto userResponseDto;
}
