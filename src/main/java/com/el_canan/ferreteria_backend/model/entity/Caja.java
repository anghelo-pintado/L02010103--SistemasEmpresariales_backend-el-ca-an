package com.el_canan.ferreteria_backend.model.entity;

import com.el_canan.ferreteria_backend.model.entityEnum.EstadoCaja;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "caja")
public class Caja {
    @Id
    @Column(name = "caja_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cajaId;
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "abierta_por", nullable = false)
    private Usuario abiertaPor;
    @Column(name = "hora_apertura", nullable = false)
    private LocalTime horaApertura;
    @Column(name = "monto_inicial", nullable = false)
    private BigDecimal montoInicial;

    @ManyToOne
    @JoinColumn(name = "cerrada_por")
    private Usuario cerradaPor;
    @Column(name = "hora_cierre")
    private LocalTime horaCierre;
    @Column(name = "monto_final")
    private BigDecimal montoFinal;

    @Enumerated(EnumType.STRING)
    private EstadoCaja estado = EstadoCaja.ABIERTA;
}

