package com.el_canan.ferreteria_backend.service;

import com.el_canan.ferreteria_backend.model.dto.UsuarioDto;
import com.el_canan.ferreteria_backend.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface IUsuarioService {
    Usuario save(UsuarioDto usuarioDtoDto);
    Usuario findById(Integer id);
    Optional<Usuario> findByUsername(String username);
    Optional<Usuario> findByEmail(String email);
    void delete(Usuario usuario);
    boolean existsById(Integer id);
    List<Usuario> findAll();
}
