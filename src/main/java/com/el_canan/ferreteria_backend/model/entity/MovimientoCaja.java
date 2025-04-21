package com.el_canan.ferreteria_backend.model.entity;

import com.el_canan.ferreteria_backend.model.entityEnum.TipoMovimiento;
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
@Table(name = "movimientos_caja")
public class MovimientoCaja {
    @Id
    @Column(name = "mov_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movId;

    @ManyToOne
    @JoinColumn(name = "caja_id", nullable = false)
    private Caja caja;

    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipo;
    @Column(name = "monto", nullable = false)
    private BigDecimal monto;
    @Column(name = "descripcion")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;
}
