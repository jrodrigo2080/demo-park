package com.jrdrigo2080.demo_park_api.service;

import com.jrdrigo2080.demo_park_api.entity.Clientes;
import com.jrdrigo2080.demo_park_api.repository.ClientesRepository;
import com.jrdrigo2080.demo_park_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientesService {

    private final ClientesRepository clientesRepository;

    @Transactional
    public Clientes create(Clientes clientes)
    {
        return clientesRepository.save(clientes);
    }

    @Transactional(readOnly = true)
    public List<Clientes> getAll()
    {
        return clientesRepository.findAll();
    }

    @Transactional
    public Clientes update(Long id, Clientes clientes)
    {
        Clientes cliente = clientesRepository.findById(id).orElseThrow(()->new RuntimeException("Cliente não encontrado."));

        cliente.setNome(clientes.getNome());
        cliente.setEmail(clientes.getEmail());
        cliente.setTelefone(clientes.getTelefone());

        return clientesRepository.save(clientes);
    }
}
