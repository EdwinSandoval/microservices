package com.example.serviceplazoleta.infraestructure.out.jpa.repository;

import com.example.serviceplazoleta.infraestructure.out.jpa.entity.Pedido_PlatosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoPlatoRepository extends JpaRepository<Pedido_PlatosEntity,Long> {
}
