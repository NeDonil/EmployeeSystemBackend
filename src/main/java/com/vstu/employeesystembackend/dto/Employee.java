package com.vstu.employeesystembackend.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    private String login;
    private String password;

    @NotNull
    private Date hireDate;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;

    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
