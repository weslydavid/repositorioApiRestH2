package com.mutualser.apirest.repository;

import com.mutualser.apirest.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository <Empleado,Long> {
}
