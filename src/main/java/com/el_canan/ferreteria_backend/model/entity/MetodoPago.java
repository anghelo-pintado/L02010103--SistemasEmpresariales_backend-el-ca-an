package com.el_canan.ferreteria_backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "metodos_pago")
public class MetodoPago {
    @Id
    @Column(name = "metodo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer metodoId;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
}
