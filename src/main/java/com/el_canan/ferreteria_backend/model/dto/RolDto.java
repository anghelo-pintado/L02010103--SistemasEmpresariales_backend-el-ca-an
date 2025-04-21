package com.el_canan.ferreteria_backend.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class RolDto {
    private Integer rolId;
    private String nombre;
    private String descripcion;
}
