package com.vstu.employeesystembackend.repository;

import com.vstu.employeesystembackend.entity.Document;
import org.springframework.data.repository.CrudRepository;

public interface DocumentRepository extends CrudRepository<Document, Long> {
}
