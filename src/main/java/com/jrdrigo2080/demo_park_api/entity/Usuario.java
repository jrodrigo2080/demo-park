package com.jrdrigo2080.demo_park_api.entity;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username", nullable = false, length = 100)
    private String username;
    @Column(name = "password", nullable = false, length = 200)
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name ="role",  nullable = false, length = 25)
    private Role role;

    @Column(name="data_criacao")
    private LocalDateTime dataCriacao;
    @Column(name="data_atualizacao")
    private LocalDateTime dataAtualizacao;
    @Column(name="criado_por")
    private String criadoPor;
    @Column(name="atualizado")
    private String atualizadoPor;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                '}';
    }

    public enum Role {
        ROLE_ADMIN, ROLE_CLIENT
    }

}
