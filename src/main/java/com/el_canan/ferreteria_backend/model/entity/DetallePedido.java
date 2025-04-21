package com.el_canan.ferreteria_backend.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "detalle_pedidos")
public class DetallePedido {
    @Id
    @Column(name = "detalle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detalleId;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Column(name = "precio_unitario", nullable = false)
    private BigDecimal precioUnitario;
    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;
}
