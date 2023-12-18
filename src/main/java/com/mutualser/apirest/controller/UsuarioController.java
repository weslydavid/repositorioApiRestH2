package com.mutualser.apirest.controller;

import com.mutualser.apirest.UsuarioService;
import com.mutualser.apirest.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @PostMapping
    public Usuario createUsuario (@RequestBody Usuario usuario){
        return usuarioService.createUsuario(usuario);
    }

    @GetMapping
    public Page<Usuario> getAllUsuarios(@PageableDefault(page = 0, size = 5) Pageable pageable){
        return usuarioService.getAllUsuarios(pageable);
    }


}
