package com.vstu.employeesystembackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="employee_id")
    private Long employeeId;

    private String username;

    private String firstname;

    private String lastname;

    private String password;

    @Column(name="hire_date")
    private LocalDate hireDate;

    @Column(name="fire_date")
    private LocalDate fireDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", referencedColumnName = "document_id")
    private Document document;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private Payment payment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rank_id", referencedColumnName = "rank_id")
    private Rank rank;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="employees_roles",
    joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private List<Role> roles = new ArrayList();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private List<Task> tasks = new ArrayList();

    public Employee(String firstName, String lastName){
        this.firstname = firstName;
        this.lastname = lastName;
    }


}
