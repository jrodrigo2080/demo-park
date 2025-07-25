package com.jrdrigo2080.demo_park_api.web.controller;

import com.jrdrigo2080.demo_park_api.entity.Usuario;
import com.jrdrigo2080.demo_park_api.repository.UsuarioRepository;
import com.jrdrigo2080.demo_park_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
      Usuario user = usuarioService.create(usuario);
      return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable Long id) {
        Usuario user = usuarioService.getById(id);
        return ResponseEntity.ok(user);
    }

    @PatchMapping("/{id}")
    public Usuario updatePassword(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario user = usuarioService.updatePassword(id, usuario.getPassword());
        return ResponseEntity.ok(user).getBody();
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll()
    {
        List<Usuario> users = usuarioService.getAll();
        return ResponseEntity.ok(users);
    }

}
