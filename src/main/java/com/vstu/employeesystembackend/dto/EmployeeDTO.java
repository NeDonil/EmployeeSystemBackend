package com.vstu.employeesystembackend.dto;

import com.vstu.employeesystembackend.entity.Employee;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class EmployeeDTO {
    private Long employeeId;
    private String username;
    private String firstname;
    private String lastname;
    private LocalDate hireDate;
    private LocalDate fireDate;
    private Long documentId;

    public static EmployeeDTO fromEntity(Employee entity){
        EmployeeDTO tmp = new EmployeeDTO();

        tmp.setEmployeeId(entity.getEmployeeId());
        tmp.setUsername(entity.getUsername());
        tmp.setFirstname(entity.getFirstname());
        tmp.setLastname(entity.getLastname());
        tmp.setHireDate(entity.getHireDate());
        tmp.setFireDate(entity.getFireDate());

        if(entity.getDocument() != null) {
            tmp.setDocumentId(entity.getDocument().getDocumentId());
        }

        return tmp;
    }
}
