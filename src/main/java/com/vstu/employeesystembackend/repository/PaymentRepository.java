package com.vstu.employeesystembackend.repository;

import com.vstu.employeesystembackend.entity.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
