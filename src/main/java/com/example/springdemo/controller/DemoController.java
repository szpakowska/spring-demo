package com.example.springdemo.controller;

import com.example.springdemo.model.EmployeeEntity;
import com.example.springdemo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {
private EmployeeRepository employeeRepository;

    public DemoController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employees/{id}")
    public EmployeeEntity getAllEmployees(@PathVariable Long id){;
        return employeeRepository.findById(id).get();
    }





}
