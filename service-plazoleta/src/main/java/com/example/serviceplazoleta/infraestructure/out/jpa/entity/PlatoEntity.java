package com.example.serviceplazoleta.infraestructure.out.jpa.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "plato")
@NoArgsConstructor//constructor vacio
//@AllArgsConstructor//constructor lleno
@Getter
@Setter
public class PlatoEntity {

    @Id
    @Column(name = "idPlato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private int precio;

    @Column(nullable = false)
    private String urlImagen;

    @Column
    private Boolean activo;

    @ManyToOne
//    @NotNull(message = "Debes especificar la categoria")
    @JoinColumn(name = "idCategoria",nullable = false)
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "idRestaurante")
    private RestauranteEntity restaurant;

    @OneToMany(mappedBy = "platos")
    private List<Pedido_PlatosEntity> pedidoPlatos;



    //idcategoria,idrestaurante
}
