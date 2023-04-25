package com.vstu.employeesystembackend;

import com.vstu.employeesystembackend.dto.Employee;
import com.vstu.employeesystembackend.repository.EmployeeRepository;
import com.vstu.employeesystembackend.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class EmployeeSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeSystemBackendApplication.class, args);
    }
    
}
