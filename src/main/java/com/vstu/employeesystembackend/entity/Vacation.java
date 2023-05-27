package com.vstu.employeesystembackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Vacation {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name="vacation_id")
    private Long vacationId;

    @Column(name="begin_date")
    LocalDate beginDate;

    @Column(name="end_date")
    LocalDate endDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", referencedColumnName = "employee_id")
    Employee employee;
}
