package com.el_canan.ferreteria_backend.model.entity;

import com.el_canan.ferreteria_backend.model.entityEnum.EstadoCotizacion;
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
@Table(name = "cotizaciones")
public class Cotizacion {
    @Id
    @Column(name = "cotizacion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cotizacionId;
    @Column(name = "num_cotizacion", nullable = false, unique = true)
    private String numCotizacion;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = false)
    private Usuario vendedor;

    @Enumerated(EnumType.STRING)
    private EstadoCotizacion estado = EstadoCotizacion.ABIERTA;
    @Column(name = "total_bruto", nullable = false)
    private BigDecimal totalBruto;
    @Column(name = "descuento")
    private BigDecimal descuento;
    @Column(name = "total_neto", nullable = false)
    private BigDecimal totalNeto;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

