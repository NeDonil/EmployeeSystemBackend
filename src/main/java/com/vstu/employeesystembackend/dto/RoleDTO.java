package com.vstu.employeesystembackend.dto;

import com.vstu.employeesystembackend.entity.Role;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class RoleDTO {
    private Long roleId;
    private String name;

    public static RoleDTO fromEntity(Role entity){
        RoleDTO tmp = new RoleDTO();

        tmp.setRoleId(entity.getRoleId());
        tmp.setName(entity.getName());

        return tmp;
    }
}
