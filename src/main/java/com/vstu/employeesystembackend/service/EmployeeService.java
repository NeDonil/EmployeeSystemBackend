package com.vstu.employeesystembackend.service;

import com.vstu.employeesystembackend.dto.EmployeeDTO;
import com.vstu.employeesystembackend.entity.Document;
import com.vstu.employeesystembackend.entity.Employee;
import com.vstu.employeesystembackend.exceptions.EmployeeCannotCreateException;
import com.vstu.employeesystembackend.exceptions.EmployeeInvalidFormatException;
import com.vstu.employeesystembackend.exceptions.EmployeeNotFoundException;
import com.vstu.employeesystembackend.repository.DepartmentRepository;
import com.vstu.employeesystembackend.repository.DocumentRepository;
import com.vstu.employeesystembackend.repository.EmployeeRepository;
import com.vstu.employeesystembackend.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    final private EmployeeRepository employeeRepository;
    final private RoleRepository roleRepository;

    final private DocumentRepository documentRepository;

    public EmployeeService(EmployeeRepository employeeRepository,
                           RoleRepository roleRepository,
                           DocumentRepository documentRepository){
        this.employeeRepository = employeeRepository;
        this.roleRepository = roleRepository;
        this.documentRepository = documentRepository;
    }

    public Employee add(Employee employee) throws EmployeeCannotCreateException{

        //TODO validation
        if(employee.getUsername() == null ||
                employee.getFirstname() == null ||
                employee.getLastname() == null ||
                employee.getPassword() == null
        ){
            throw new EmployeeCannotCreateException("Employee must have username, firstname, lastname, pswd");
        }

        if(employee.getUsername() == "" ||
                employee.getFirstname() == "" ||
                employee.getLastname() == "" ||
                employee.getPassword() == ""){
            throw new EmployeeCannotCreateException("Employee credentials cannot be empty");
        }

        if(employee.getFireDate() == null) {
            employee.setHireDate(java.time.LocalDate.now());
        }

        Document tmpDocument = documentRepository.findById(1L).get();
        employee.setDocument(tmpDocument);

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

    public Employee update(Long id, EmployeeDTO employeeDTO) throws EmployeeNotFoundException, EmployeeInvalidFormatException{

        if(employeeDTO.getFirstname() == null || employeeDTO.getLastname() == null || employeeDTO.getFireDate() == null){
            throw new EmployeeInvalidFormatException("Employee must have firstname, lastname, firedate");
        }

        var employeeCandid = employeeRepository.findById(id);
        if(employeeCandid.isPresent()) {
            var employee = employeeCandid.get();

            employee.setFirstname(employeeDTO.getFirstname());
            employee.setLastname(employeeDTO.getLastname());
            employee.setFireDate(employeeDTO.getFireDate());

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
