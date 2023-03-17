package com.example.serviceplazoleta.infraestructure.out.jpa.repository;

import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PlatoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPlatoRepository extends JpaRepository<PlatoEntity,Long> {
}
