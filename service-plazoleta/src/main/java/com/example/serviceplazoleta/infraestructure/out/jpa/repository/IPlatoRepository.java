package com.example.serviceplazoleta.infraestructure.out.jpa.repository;

import com.example.serviceplazoleta.domain.model.CategoriaModel;
import com.example.serviceplazoleta.domain.model.PlatoModel;
import com.example.serviceplazoleta.infraestructure.out.jpa.entity.PlatoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import javax.swing.text.html.parser.Entity;
import java.util.List;

public interface IPlatoRepository extends JpaRepository<PlatoEntity,Long> {
//    @Query(value = "select * from plato p group by p.id_categoria",
//            nativeQuery = true)
//    List<PlatoEntity> findAllPlatos(Pageable pageable);


    @Query(value = "select * from plato p " +
            "inner join restaurante r on p.id_restaurante=r.id_restaurante " +
            "where r.id_restaurante = :idRestaurante "+
            "order by p.id_categoria asc",

    countQuery = "select count(*) from plato p " +
        "inner join restaurante r on p.id_restaurante=r.id_restaurante " +
        "where r.id_restaurante = :idRestaurante "+
            "order by p.id_categoria asc",
//            "order by p.id_categoria asc limit 4",
            nativeQuery = true)
    Page<PlatoEntity> agruparPorCategoria(@Param("idRestaurante") Long idRestaurante, Pageable pageable);


}
