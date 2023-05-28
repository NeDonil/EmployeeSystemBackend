package com.vstu.employeesystembackend.controller;

import com.vstu.employeesystembackend.dto.EmployeeDTO;
import com.vstu.employeesystembackend.dto.TaskDTO;
import com.vstu.employeesystembackend.dto.VacationDTO;
import com.vstu.employeesystembackend.entity.Task;
import com.vstu.employeesystembackend.exceptions.TaskCannotCreateException;
import com.vstu.employeesystembackend.exceptions.TaskNotFoundException;
import com.vstu.employeesystembackend.exceptions.VacationCannotCreateException;
import com.vstu.employeesystembackend.service.TaskService;
import com.vstu.employeesystembackend.service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/vacations")
@RestController
public class VacationController {

    @Autowired
    private final VacationService vacationService;

    public VacationController(VacationService service) {this.vacationService = service;}
    @PostMapping
    public ResponseEntity add(@RequestBody VacationDTO vacationDTO){
        try{
            return ResponseEntity.ok().body(VacationDTO.fromEntity(vacationService.add(vacationDTO)));
        } catch(VacationCannotCreateException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
