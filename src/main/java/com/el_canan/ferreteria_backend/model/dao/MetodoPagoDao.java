package com.el_canan.ferreteria_backend.model.dao;

import com.el_canan.ferreteria_backend.model.entity.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetodoPagoDao extends JpaRepository<MetodoPago, Integer> {
}
