package com.vstu.employeesystembackend.repository;

import com.vstu.employeesystembackend.dto.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
