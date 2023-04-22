package com.vstu.employeesystembackend.service;

import com.vstu.employeesystembackend.dto.Role;
import com.vstu.employeesystembackend.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {
    final private RoleRepository roleRepository;
    @Autowired
    public RoleService(RoleRepository repository){
        this.roleRepository = repository;
    }

    public Role add(Role role){
        return roleRepository.save(role);
    }

    public List<Role> getAll(){
        List<Role> roles = new ArrayList<Role>();
        Iterable<Role> result = roleRepository.findAll();

        result.forEach(roles::add);
        return roles;
    }

    public Role update(Long id, Role role){
        if(roleRepository.existsById(id)) {
            role.setRoleId(id);
            return roleRepository.save(role);
        };

        //TODO throw exception
        return new Role();
    }

    public void delete(Long id){
        roleRepository.deleteById(id);
    }
}
