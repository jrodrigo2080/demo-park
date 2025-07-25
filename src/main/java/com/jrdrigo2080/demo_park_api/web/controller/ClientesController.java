package com.jrdrigo2080.demo_park_api.web.controller;

import com.jrdrigo2080.demo_park_api.entity.Clientes;
import com.jrdrigo2080.demo_park_api.entity.Usuario;
import com.jrdrigo2080.demo_park_api.service.ClientesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/clientes")
public class ClientesController {

    private final ClientesService clientesService;

    @PostMapping
    public ResponseEntity<Clientes> create(@RequestBody Clientes clientes)
    {
        Clientes cliente = clientesService.create(clientes);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

   @GetMapping
    public ResponseEntity<List<Clientes>> findAll() {
       List<Clientes> clients = clientesService.getAll();
       return ResponseEntity.ok(clients);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> update(@PathVariable Long id, @RequestBody Clientes clientes)
    {
        Clientes cliente = clientesService.update(id, clientes);
        return ResponseEntity.ok(cliente);
    }


}
