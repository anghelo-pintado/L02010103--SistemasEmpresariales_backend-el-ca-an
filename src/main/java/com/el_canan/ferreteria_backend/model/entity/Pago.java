package com.el_canan.ferreteria_backend.model.entity;

import com.el_canan.ferreteria_backend.model.entityEnum.EstadoPago;
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
@Table(name = "pagos")
public class Pago {
    @Id
    @Column(name = "pago_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pagoId;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "cajero_id", nullable = false)
    private Usuario cajero;

    @ManyToOne
    @JoinColumn(name = "metodo_id", nullable = false)
    private MetodoPago metodoPago;
    @Column(name = "monto", nullable = false)
    private BigDecimal monto;

    @Enumerated(EnumType.STRING)
    private EstadoPago estado = EstadoPago.EN_PROCESO;
    @Column(name = "referencia")
    private String referencia;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

