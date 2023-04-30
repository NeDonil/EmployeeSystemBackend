package com.vstu.employeesystembackend.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long taskId;

    private String name;
    private String text;
    private LocalDateTime startline;
    private LocalDateTime deadline;

    @ManyToOne()
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    private Employee employee;

    public Task(String name, Employee employee){
        this.name = name;
        this.employee = employee;
    }

}
