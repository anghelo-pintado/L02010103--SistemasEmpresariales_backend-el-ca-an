package com.el_canan.ferreteria_backend.model.entity;

import com.el_canan.ferreteria_backend.model.entityEnum.EstadoUsuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @Column(name = "usuario_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuariosId;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "password_hash", nullable = false)
    private String passwordHash;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "telefono", columnDefinition = "CHAR(9)")
    private String telefono;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rol_id", nullable = false)
    @ToString.Exclude
    private Rol rol;
    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado = EstadoUsuario.ACTIVO;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

