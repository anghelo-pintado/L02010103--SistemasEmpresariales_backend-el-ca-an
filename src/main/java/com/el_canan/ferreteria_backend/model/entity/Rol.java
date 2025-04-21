package com.el_canan.ferreteria_backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "roles")
public class Rol {
    @Id
    @Column(name = "rol_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rolId;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
}
