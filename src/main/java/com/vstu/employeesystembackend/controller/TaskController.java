package com.vstu.employeesystembackend.controller;

import com.vstu.employeesystembackend.dto.EmployeeDTO;
import com.vstu.employeesystembackend.dto.TaskDTO;
import com.vstu.employeesystembackend.entity.Task;
import com.vstu.employeesystembackend.exceptions.TaskCannotCreateException;
import com.vstu.employeesystembackend.exceptions.TaskNotFoundException;
import com.vstu.employeesystembackend.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/tasks")
@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService service){
        this.taskService = service;
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(taskService.getAll().stream().map(TaskDTO::fromEntity));
    }

    @PostMapping
    public ResponseEntity add(@RequestBody TaskDTO taskDTO){
        try{
            return ResponseEntity.ok().body(TaskDTO.fromEntity(taskService.add(taskDTO)));
        } catch(TaskCannotCreateException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        try{
            return ResponseEntity.ok().body(TaskDTO.fromEntity(taskService.update(id, taskDTO)));
        } catch(TaskNotFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try{
            taskService.delete(id);
            return ResponseEntity.ok().build();
        } catch(TaskNotFoundException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
