package com.vstu.employeesystembackend.service;

import com.vstu.employeesystembackend.dto.Employee;
import com.vstu.employeesystembackend.errors.EmployeeNotFoundException;
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

    public Employee getOne(Long id) throws EmployeeNotFoundException{
        var employeeCandidate = employeeRepository.findById(id);
        if(employeeCandidate.isPresent()){
            return employeeCandidate.get();
        } else {
            throw new EmployeeNotFoundException(String.format("Employee(%d) not found", id));
        }
    }

    public Employee update(Long id, Employee employee) throws EmployeeNotFoundException{
        if(employeeRepository.existsById(id)) {
            employee.setEmployeeId(id);
            return employeeRepository.save(employee);
        } else {
            throw new EmployeeNotFoundException(String.format("Employee(%d) not found", id));
        }
    }

    public void delete(Long id) throws EmployeeNotFoundException{
        if(employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new EmployeeNotFoundException(String.format("Employee(%d) not found", id));
        }
    }
}
