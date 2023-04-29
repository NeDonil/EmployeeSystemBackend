package com.vstu.employeesystembackend.controller;

import com.vstu.employeesystembackend.dto.Employee;
import com.vstu.employeesystembackend.errors.EmployeeNotFoundException;
import com.vstu.employeesystembackend.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService service){
        this.employeeService = service;
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(@PathVariable Long id){
        try{
            Employee employee = employeeService.getOne(id);
            return ResponseEntity.ok().body(employee);
        } catch(EmployeeNotFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.add(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Employee employee){
        try{
            return ResponseEntity.ok().body(employeeService.update(id, employee));
        } catch(EmployeeNotFoundException ex){
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
