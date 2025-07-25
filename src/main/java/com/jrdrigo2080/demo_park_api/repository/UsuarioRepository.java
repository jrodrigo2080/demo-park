package com.jrdrigo2080.demo_park_api.repository;

import com.jrdrigo2080.demo_park_api.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
