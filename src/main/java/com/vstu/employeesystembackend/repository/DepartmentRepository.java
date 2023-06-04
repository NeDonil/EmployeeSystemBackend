package com.vstu.employeesystembackend.repository;

import com.vstu.employeesystembackend.entity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
