package com.example.serviceplazoleta.infraestructure.out.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "restaurante")
@NoArgsConstructor//constructor vacio
@AllArgsConstructor//constructor lleno
@Getter
@Setter

public class RestauranteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRestaurante")
    private Long id;

    @Column
    @NotBlank(message = "Debes especificar el nombre")
    private String nombre;

    @Column
    @NotBlank(message = "Debes especificar la direccion")
    private String direccion;

    @Column
    @Size(max = 13, message = "El maximo es 13 numeros")
    private String telefono;

    @Column
    @NotBlank(message = "Debes especificar su la url de logo")
    private String urlLogo;

    @Column
    @NotBlank(message = "Debes especificar su nit")
    @Size(max = 11,message = "El maximo de nuemeros es 11")
    private String nit;

    @Column
    @NotNull(message = "Debes especificar el id de Propietario")
    private  Long idPropietario;//

    @OneToMany(mappedBy = "restaurant")
    private List<PedidoEntity> pedido;

    @OneToMany(mappedBy = "restaurant")//la variable q esta dentro es la que se creo en la entidad usuario
    private List<PlatoEntity> platos;
    //idpropietario
}
