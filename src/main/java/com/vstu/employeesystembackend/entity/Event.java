package com.vstu.employeesystembackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Event {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name="event_id")
    private Long id;

    private LocalDate date;
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employeeId;
}
