package com.mutualser.apirest.controller;

import com.mutualser.apirest.EmpleadoService;
import com.mutualser.apirest.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;
    @PostMapping
    public Empleado createEmpleado (@RequestBody Empleado empleado){
    return empleadoService.createEmplado(empleado);
    }

    @GetMapping("{id}")
    public Empleado getEmpleadoById(@PathVariable("id") Long id){
        return empleadoService.getEmpleadoById(id);
    }

    @GetMapping
    public Page<Empleado> getAllEmpleados(@PageableDefault(page = 0, size = 2)Pageable pageable){
        return empleadoService.getAllEmpleados(pageable);
    }

    @DeleteMapping("{id}")
    public void deleteEmpleadoById(@PathVariable("id") Long id){
        empleadoService.deleteEmpleado(id);
    }

}
