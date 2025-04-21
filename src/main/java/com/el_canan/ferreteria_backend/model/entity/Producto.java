package com.el_canan.ferreteria_backend.model.entity;

import com.el_canan.ferreteria_backend.model.entityEnum.EstadoProducto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "producto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productoId;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "categoria_id", nullable = false)
    @ToString.Exclude
    private Categoria categoria;
    @Column(name="precio_unitario", nullable = false)
    private BigDecimal precio;
    @Column(name = "costo")
    private BigDecimal  costo;
    @Column(name = "stock", nullable = false)
    private Integer stock;
    @Enumerated(EnumType.STRING)
    private EstadoProducto estado = EstadoProducto.ACTIVO;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}

