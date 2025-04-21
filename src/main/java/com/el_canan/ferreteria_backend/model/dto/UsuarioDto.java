package com.el_canan.ferreteria_backend.model.dto;

import com.el_canan.ferreteria_backend.model.entity.Rol;
import com.el_canan.ferreteria_backend.model.entityEnum.EstadoUsuario;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString
@Builder
public class UsuarioDto {
    private Integer usuariosId;
    private String username;
    @ToString.Exclude
    private String passwordHash;
    private String email;
    private String nombre;
    private String apellido;
    private String telefono;
    private Rol rol;
    private EstadoUsuario estado = EstadoUsuario.ACTIVO;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
