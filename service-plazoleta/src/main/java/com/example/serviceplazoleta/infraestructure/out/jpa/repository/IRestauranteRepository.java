package com.example.serviceplazoleta.infraestructure.out.jpa.repository;

import com.example.serviceplazoleta.infraestructure.out.jpa.entity.RestauranteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRestauranteRepository extends JpaRepository<RestauranteEntity,Long> {
}
