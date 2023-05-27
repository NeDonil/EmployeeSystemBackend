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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="employees_roles",
    joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )

    private List<Role> roles = new ArrayList();

    public Employee(String firstName, String lastName){
        this.firstname = firstName;
        this.lastname = lastName;
    }


}