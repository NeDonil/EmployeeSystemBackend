package com.vstu.employeesystembackend.controller;

import com.vstu.employeesystembackend.dto.Task;
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
        return ResponseEntity.ok(taskService.add(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Task role){
        return ResponseEntity.ok().body(taskService.update(id, role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

}
