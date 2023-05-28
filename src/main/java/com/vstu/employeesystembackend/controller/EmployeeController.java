package com.vstu.employeesystembackend.controller;

import com.vstu.employeesystembackend.dto.EmployeeDTO;
import com.vstu.employeesystembackend.entity.Employee;
import com.vstu.employeesystembackend.exceptions.EmployeeCannotCreateException;
import com.vstu.employeesystembackend.exceptions.EmployeeInvalidFormatException;
import com.vstu.employeesystembackend.exceptions.EmployeeNotFoundException;
import com.vstu.employeesystembackend.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService service){
        this.employeeService = service;
    }

    @GetMapping
    public ResponseEntity getAll(){

        return ResponseEntity.ok().body(employeeService.getAll().stream().map(EmployeeDTO::fromEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        try{
            Employee employee = employeeService.getOne(id);
            return ResponseEntity.ok().body(EmployeeDTO.fromEntity(employee));
        } catch(EmployeeNotFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity add(@Valid @RequestBody Employee employee){
        try{
            Employee newEmployee = employeeService.add(employee);
            return ResponseEntity.ok().body(EmployeeDTO.fromEntity(newEmployee));
        } catch(EmployeeCannotCreateException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO){
        try{
            return ResponseEntity.ok().body(EmployeeDTO.fromEntity(employeeService.update(id, employeeDTO)));
        } catch(EmployeeNotFoundException ex){ // TODO: Use interfaces
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch(EmployeeInvalidFormatException ex){ // TODO: Use interfaces
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        try{
            employeeService.delete(id);
            return ResponseEntity.ok().build();
        } catch (EmployeeNotFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }



    }

}
