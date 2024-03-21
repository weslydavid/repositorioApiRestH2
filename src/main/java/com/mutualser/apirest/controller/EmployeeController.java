package com.mutualser.apirest.controller;

import com.mutualser.apirest.model.Employee;
import com.mutualser.apirest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public Employee createEmployee (@RequestBody Employee employee){
        return employeeService.createEmployee(employee);
    }

    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public Page<Employee> getAllEmployee(@PageableDefault(page = 0, size = 30) Pageable pageable){
        return employeeService.getAllEmployee(pageable);
    }

    @DeleteMapping("{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }
}
