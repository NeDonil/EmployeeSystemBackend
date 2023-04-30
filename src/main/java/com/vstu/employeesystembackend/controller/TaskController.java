package com.vstu.employeesystembackend.controller;

import com.vstu.employeesystembackend.dto.Task;
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
        return ResponseEntity.ok().body(taskService.getAll());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Task task){
        try{
            return ResponseEntity.ok().body(taskService.add(task));
        } catch(TaskCannotCreateException ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Task task){
        try{
            return ResponseEntity.ok().body(taskService.update(id, task));
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
