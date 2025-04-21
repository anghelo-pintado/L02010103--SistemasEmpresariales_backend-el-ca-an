package com.el_canan.ferreteria_backend.model.dao;

import com.el_canan.ferreteria_backend.model.entity.Cotizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotizacionDao extends JpaRepository<Cotizacion, Integer> {
}
