package com.vstu.employeesystembackend.dto;

import com.vstu.employeesystembackend.entity.Authority;
import lombok.Data;

@Data
public class AuthorityDTO {

    private Long authorityId;
    private String name;

    public static AuthorityDTO fromEntity(Authority entity){
        AuthorityDTO tmp = new AuthorityDTO();

        tmp.setAuthorityId(entity.getAuthorityId());
        tmp.setName(entity.getName());
        return tmp;
    }
}

