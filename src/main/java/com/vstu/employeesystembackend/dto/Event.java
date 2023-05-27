package com.vstu.employeesystembackend.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
public class Event {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name="event_id")
    private Long id;

    private LocalDate date;
    private String name;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employeeId;
}
