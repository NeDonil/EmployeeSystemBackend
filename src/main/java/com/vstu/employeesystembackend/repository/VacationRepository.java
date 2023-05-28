package com.vstu.employeesystembackend.repository;

import com.vstu.employeesystembackend.entity.Vacation;
import org.springframework.data.repository.CrudRepository;

public interface VacationRepository extends CrudRepository<Vacation, Long> {
}
