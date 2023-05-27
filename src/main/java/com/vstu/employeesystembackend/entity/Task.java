package com.vstu.employeesystembackend.entity;

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
    @Column(name="task_id")
    private Long taskId;

    private String name;
    private String description;
    private LocalDateTime startline;
    private LocalDateTime deadline;

    @Column(name="complete_stage")
    private String completeStage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;

    public Task(String name, Employee employee){
        this.name = name;
        this.employee = employee;
    }

}
