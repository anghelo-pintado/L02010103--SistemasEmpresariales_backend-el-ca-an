package com.el_canan.ferreteria_backend.model.entity;

import com.el_canan.ferreteria_backend.model.entityEnum.EstadoComprobante;
import com.el_canan.ferreteria_backend.model.entityEnum.TipoComprobante;
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
@Table(name = "comprobantes")
public class Comprobante {
    @Id
    @Column(name = "comprobante_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer comprobanteId;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @Enumerated(EnumType.STRING)
    private TipoComprobante tipo;
    @Column(name = "num_comprobante", nullable = false, unique = true)
    private String numComprobante;
    private LocalDateTime fechaEmision;
    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private EstadoComprobante estado = EstadoComprobante.EMITIDO;
    @Column(name = "justificacion_anulacion")
    private String justificacionAnulacion;

    @ManyToOne
    @JoinColumn(name = "autoriza_anulacion")
    private Usuario autorizaAnulacion;
    @Column(name = "cliente_email")
    private String clienteEmail;
}

