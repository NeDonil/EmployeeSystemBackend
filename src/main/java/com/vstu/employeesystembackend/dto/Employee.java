package com.vstu.employeesystembackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;

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

    @JsonIgnore
    private String login;
    @JsonIgnore
    private String password;

    @NotNull
    private LocalDate hireDate;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Role role;

    public Employee(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
