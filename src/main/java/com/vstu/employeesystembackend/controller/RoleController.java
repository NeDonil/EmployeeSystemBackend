package com.vstu.employeesystembackend.controller;

import com.vstu.employeesystembackend.entity.Role;
import com.vstu.employeesystembackend.service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/roles")
@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService service){
        this.roleService = service;
    }

    @GetMapping
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(roleService.getAll());
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Role role){
        return ResponseEntity.ok(roleService.add(role));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Role role){
        return ResponseEntity.ok().body(roleService.update(id, role));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        roleService.delete(id);
        return ResponseEntity.ok().build();
    }

}
