package com.example.serviceplazoleta.infraestructure.out.jpa.repository;

import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPedidoRepository extends JpaRepository<PedidoEntity,Long> {
}
