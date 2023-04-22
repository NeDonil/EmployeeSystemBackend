package com.vstu.employeesystembackend.controller;

import com.vstu.employeesystembackend.dto.Employee;
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

    @PostMapping
    public ResponseEntity add(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.add(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Employee employee){
        return ResponseEntity.ok().body(employeeService.update(id, employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        employeeService.delete(id);
        return ResponseEntity.ok().build();
    }

}
