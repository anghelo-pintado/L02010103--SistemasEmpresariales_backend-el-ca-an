package com.el_canan.ferreteria_backend.service.impl;

import com.el_canan.ferreteria_backend.model.dao.RolDao;
import com.el_canan.ferreteria_backend.model.dto.RolDto;
import com.el_canan.ferreteria_backend.model.entity.Rol;
import com.el_canan.ferreteria_backend.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RolServiceImpl implements IRolService {
    @Autowired
    private RolDao rolDao;

    @Transactional
    @Override
    public Rol save(RolDto rolDto) {
        Rol rol = Rol.builder()
                .rolId(rolDto.getRolId())
                .nombre(rolDto.getNombre())
                .descripcion(rolDto.getDescripcion())
                .build();
        return rolDao.save(rol);
    }

    @Transactional(readOnly = true)
    @Override
    public Rol findById(Integer id) {
        return rolDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Rol rol) {
        rolDao.delete(rol);
    }

    @Override
    public boolean existsById(Integer id) {
        return rolDao.existsById(id);
    }

    @Override
    public List<Rol> findAll() {
        return (List<Rol>) rolDao.findAll();
    }
}
