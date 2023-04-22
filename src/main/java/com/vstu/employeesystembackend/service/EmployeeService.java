package com.vstu.employeesystembackend.service;

import com.vstu.employeesystembackend.dto.Employee;
import com.vstu.employeesystembackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    final private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository repository){
        this.employeeRepository = repository;
    }

    public Employee add(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAll(){
        List<Employee> employees = new ArrayList<Employee>();
        Iterable<Employee> result = employeeRepository.findAll();

        result.forEach(employees::add);
        return employees;
    }

    public Employee update(Long id, Employee employee){
        if(employeeRepository.existsById(id)) {
            employee.setEmployeeId(id);
            return employeeRepository.save(employee);
        };

        //TODO throw exception
        return new Employee();
    }

    public void delete(Long id){
        employeeRepository.deleteById(id);
    }
}
