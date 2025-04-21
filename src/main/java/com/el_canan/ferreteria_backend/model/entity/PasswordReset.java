package com.el_canan.ferreteria_backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "password_resets")
public class PasswordReset {
    @Id
    @Column(name = "reset_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resetId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private String token;
    private LocalDateTime expiresAt;
    private LocalDateTime createdAt;
}
