package com.example.springdemo.controller;

import com.example.springdemo.model.EmployeeEntity;
import com.example.springdemo.repository.EmployeeRepository;
import com.example.springdemo.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DemoController {
    private EmployeeService employeeService;

    public DemoController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/employees")
    public List<EmployeeEntity> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
