package com.vstu.employeesystembackend.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long taskId;

    private String name;
    private String text;
    private LocalDateTime startline;
    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
