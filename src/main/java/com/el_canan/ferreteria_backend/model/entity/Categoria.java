package com.el_canan.ferreteria_backend.model.entity;

import com.el_canan.ferreteria_backend.model.entityEnum.EstadoCategoria;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "categorias")
public class Categoria {
    @Id
    @Column(name = "categoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoriaId;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Enumerated(EnumType.STRING)
    private EstadoCategoria estado = EstadoCategoria.ACTIVO;
}

