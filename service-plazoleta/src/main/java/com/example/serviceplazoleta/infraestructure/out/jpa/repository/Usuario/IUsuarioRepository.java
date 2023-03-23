package com.example.serviceplazoleta.infraestructure.out.jpa.repository.Usuario;

import com.example.serviceplazoleta.domain.model.Usuario.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsuarioRepository extends JpaRepository<UsuarioModel,Long> {
    Optional<UsuarioModel> findByEmail(String email);
}
