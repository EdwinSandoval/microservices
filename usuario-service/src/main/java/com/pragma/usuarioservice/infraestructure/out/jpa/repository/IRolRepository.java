package com.pragma.usuarioservice.infraestructure.out.jpa.repository;

import com.pragma.usuarioservice.infraestructure.out.jpa.entity.RolEntity;
import com.pragma.usuarioservice.infraestructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRolRepository extends JpaRepository<RolEntity,Long> {
}
