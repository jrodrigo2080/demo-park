package com.jrdrigo2080.demo_park_api.repository;

import com.jrdrigo2080.demo_park_api.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
