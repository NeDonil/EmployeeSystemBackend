package com.vstu.employeesystembackend.repository;


import com.vstu.employeesystembackend.dto.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
