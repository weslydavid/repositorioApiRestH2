package com.mutualser.apirest.service;

import com.mutualser.apirest.model.Employee;
import org.springframework.stereotype.Service;
import com.mutualser.apirest.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(Long id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.get();
    }

    public Page<Employee> getAllEmployee(Pageable pageable){
        return employeeRepository.findAll(pageable);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
