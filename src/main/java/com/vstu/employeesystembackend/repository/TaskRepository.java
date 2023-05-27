package com.vstu.employeesystembackend.repository;


import com.vstu.employeesystembackend.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
