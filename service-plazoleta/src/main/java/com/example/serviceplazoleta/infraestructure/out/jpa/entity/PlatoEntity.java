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

    @Column
    @NotBlank
    @NotNull(message = "Debes especificar el nombre")
    private String nombre;

    @Column
    @NotBlank
    @NotNull(message = "Debes especificar la descripcion")
    private String descripcion;

    @Column
    @NotNull(message = "Debes especificar el precio")
    private int precio;

    @Column
    @NotBlank
    @NotNull(message = "Debes especificar la url")
    private String urlImagen;

    @Column
    @ColumnDefault("1")
    private Boolean activo;

    @ManyToOne
//    @NotNull(message = "Debes especificar la categoria")
    @JoinColumn(name = "idCategoria")
    private CategoriaEntity categoria;

    @ManyToOne
    @JoinColumn(name = "idRestaurante")
    private RestauranteEntity restaurant;

    @OneToMany(mappedBy = "platos")
    private List<Pedido_PlatosEntity> pedidoPlatos;

    public PlatoEntity(Long id, String nombre, String descripcion, int precio, String urlImagen,
                       Boolean activo, CategoriaEntity categoria, RestauranteEntity restaurant,
                       List<Pedido_PlatosEntity> pedidoPlatos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.urlImagen = urlImagen;
        this.activo = true;
        this.categoria = categoria;
        this.restaurant = restaurant;
        this.pedidoPlatos = pedidoPlatos;
    }

    //idcategoria,idrestaurante
}
