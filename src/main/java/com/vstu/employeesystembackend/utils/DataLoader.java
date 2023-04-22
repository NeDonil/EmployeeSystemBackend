package com.vstu.employeesystembackend.utils;

import com.vstu.employeesystembackend.dto.Employee;
import com.vstu.employeesystembackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private EmployeeRepository employeeRepository;

    @Autowired
    public DataLoader(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    public void run(ApplicationArguments args) {
        employeeRepository.save(new Employee("Danil", "Svinoukhov"));
        employeeRepository.save(new Employee("Ilya", "Ignatenko"));
        employeeRepository.save(new Employee("Andrew", "Abramov"));
        employeeRepository.save(new Employee("Danil", "Kabirov"));
    }
}
