package com.vstu.employeesystembackend.service;

import com.vstu.employeesystembackend.dto.Employee;
import com.vstu.employeesystembackend.exceptions.EmployeeCannotCreateException;
import com.vstu.employeesystembackend.exceptions.EmployeeNotFoundException;
import com.vstu.employeesystembackend.repository.EmployeeRepository;
import com.vstu.employeesystembackend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    final private EmployeeRepository employeeRepository;
    final private RoleRepository roleRepository;

    public EmployeeService(EmployeeRepository employeeRepository, RoleRepository roleRepository){
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
    }

    public Employee add(Employee employee) throws EmployeeCannotCreateException{

        if(employee.getUsername() == null || employee.getFirstname() == null || employee.getLastname() == null ){
            throw new EmployeeCannotCreateException("Employee must have firstname, lastname, username");
        }

        if(employee.getUsername() == "" || employee.getFirstname() == "" || employee.getLastname() == "" ){
            throw new EmployeeCannotCreateException("Employee credentials cannot be empty");
        }

        employee.setHireDate(java.time.LocalDate.now());


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
