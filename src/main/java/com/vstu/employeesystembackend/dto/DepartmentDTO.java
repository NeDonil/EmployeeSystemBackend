package com.vstu.employeesystembackend.dto;

import com.vstu.employeesystembackend.entity.Department;
import lombok.Data;
@Data
public class DepartmentDTO {
    private Long departmentId;
    private String name;

    public static DepartmentDTO fromEntity(Department entity){
        DepartmentDTO tmp = new DepartmentDTO();

        tmp.setDepartmentId(entity.getDepartmentId());
        tmp.setName(entity.getName());

        return tmp;
    }
}