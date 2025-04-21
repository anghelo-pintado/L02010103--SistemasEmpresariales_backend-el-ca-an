package com.el_canan.ferreteria_backend.service;



import com.el_canan.ferreteria_backend.model.dto.RolDto;
import com.el_canan.ferreteria_backend.model.entity.Rol;

import java.util.List;

public interface IRolService {
    Rol save(RolDto rolDto);
    Rol findById(Integer id);
    void delete(Rol rol);
    boolean existsById(Integer id);
    List<Rol> findAll();
}
