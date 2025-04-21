package com.el_canan.ferreteria_backend.controller;

import com.el_canan.ferreteria_backend.model.dto.RolDto;
import com.el_canan.ferreteria_backend.model.entity.Rol;
import com.el_canan.ferreteria_backend.service.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RolController {
    @Autowired
    private IRolService rolService;

    @PostMapping("rol")
    public ResponseEntity<?> create(@RequestBody RolDto rolDto) {
        Rol rolSave = null;
        try {
            rolSave = rolService.save(rolDto);
            return new ResponseEntity<>(
                    RolDto.builder()
                            .rolId(rolSave.getRolId())
                            .nombre(rolSave.getNombre())
                            .descripcion(rolSave.getDescripcion())
                            .build()
                    , HttpStatus.CREATED);
        }
        catch (DataAccessException e) {
            return new ResponseEntity<>(
                    "Error al insertar el rol: " + e.getMessage()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("rol/{id}")
    public ResponseEntity<?> update(@RequestBody RolDto rolDto, @PathVariable Integer id) {
        Rol rolUpdate = null;
        try {
            if (rolService.existsById(id)) {
                rolDto.setRolId(id);
                rolUpdate = rolService.save(rolDto);
                return new ResponseEntity<>(
                        RolDto.builder()
                                .rolId(rolUpdate.getRolId())
                                .nombre(rolUpdate.getNombre())
                                .descripcion(rolUpdate.getDescripcion())
                                .build()
                        , HttpStatus.CREATED);
            }
            return new ResponseEntity<>(
                    "El rol con ID " + id + " no existe."
                    , HttpStatus.NOT_FOUND);
        }
        catch (DataAccessException e) {
            return new ResponseEntity<>(
                    "Error al actualizar el rol: " + e.getMessage()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("rol/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Rol rol = null;
        try {
            rol = rolService.findById(id);
            if (rol == null) {
                return new ResponseEntity<>(
                        "El rol con ID " + id + " no existe."
                        , HttpStatus.NOT_FOUND);
            }
            rolService.delete(rol);
            // 204 No Content se utiliza cuando la eliminación es exitosa y no se envía contenido en la respuesta.
            return ResponseEntity.noContent().build();
        }
        catch (DataAccessException e) {
            return new ResponseEntity<>(
                    "Error al eliminar el rol: " + e.getMessage()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("rol/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Rol rol = rolService.findById(id);
        if (rol == null) {
            return new ResponseEntity<>(
                    "El rol con ID " + id + " no existe."
                    , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                RolDto.builder()
                        .rolId(rol.getRolId())
                        .nombre(rol.getNombre())
                        .descripcion(rol.getDescripcion())
                        .build()
                , HttpStatus.OK);
    }

    @GetMapping("roles")
    public ResponseEntity<?> showAll() {
        List<Rol> roles = rolService.findAll();

        if (roles.isEmpty()) {
            return new ResponseEntity<>(
                    "No hay roles registrados."
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(
                roles
                , HttpStatus.OK);
    }
}
