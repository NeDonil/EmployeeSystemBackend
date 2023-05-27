package com.vstu.employeesystembackend.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Department {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name="department_id")
    private Long departmentId;

    private String name;
}
