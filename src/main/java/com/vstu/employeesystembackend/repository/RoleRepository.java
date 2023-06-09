package com.vstu.employeesystembackend.repository;

import com.vstu.employeesystembackend.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
