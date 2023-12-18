package com.mutualser.apirest;

import com.mutualser.apirest.model.Usuario;
import com.mutualser.apirest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> getAllUsuarios(Pageable pageable){
        return usuarioRepository.findAll(pageable);
    }
}
