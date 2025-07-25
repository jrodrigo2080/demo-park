package com.jrdrigo2080.demo_park_api.service;

import com.jrdrigo2080.demo_park_api.entity.Usuario;
import com.jrdrigo2080.demo_park_api.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario create(Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> getAll()
    {
        return usuarioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Usuario getById(Long id)
    {
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não localizado"));
    }

    @Transactional
    public Usuario updatePassword(Long id, String password)
    {
         Usuario user = getById(id);
         user.setPassword(password);
         return user;
    }
}
