package com.vstu.employeesystembackend.repository;

import com.vstu.employeesystembackend.dto.Authority;
import com.vstu.employeesystembackend.dto.Employee;
import org.springframework.data.repository.CrudRepository;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {
}
