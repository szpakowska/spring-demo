package com.example.springdemo.service;

import com.example.springdemo.model.EmployeeEntity;
import com.example.springdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity getEmployeeById(@PathVariable Long id){;
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
        return optionalEmployeeEntity.orElse(null);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
