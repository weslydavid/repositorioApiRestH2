package com.mutualser.apirest;

import com.mutualser.apirest.model.Empleado;
import com.mutualser.apirest.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public Empleado createEmplado(Empleado empleado){
        return empleadoRepository.save(empleado);
    }

    public Empleado getEmpleadoById(Long id){
        Optional<Empleado> optionalEmpleado = empleadoRepository.findById(id);
        return optionalEmpleado.get();
    }

    public Page<Empleado> getAllEmpleados(Pageable pageable){
        return empleadoRepository.findAll(pageable);
    }

    public void deleteEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }

}
