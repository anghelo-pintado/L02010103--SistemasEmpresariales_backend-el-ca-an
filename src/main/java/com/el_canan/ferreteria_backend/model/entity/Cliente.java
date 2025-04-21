package com.el_canan.ferreteria_backend.model.entity;

import com.el_canan.ferreteria_backend.model.entityEnum.TipoDocumento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @Column(name = "cliente_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clienteId;
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDoc;
    @Column(name = "num_doc", nullable = false, unique = true)
    private String numDoc;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    private LocalDateTime createdAt;
}

