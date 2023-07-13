package com.example.serviceplazoleta.infraestructure.out.jpa.repository;

import com.example.serviceplazoleta.infraestructure.out.jpa.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICategoriaRepository extends JpaRepository<CategoriaEntity,Long> {

    CategoriaEntity findByIdCategoria(Long id);
}
