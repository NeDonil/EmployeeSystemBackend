package com.vstu.employeesystembackend.dto;

import com.vstu.employeesystembackend.entity.Rank;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RankDTO {
    private Long rankId;
    private String name;
    private Long departmentId;

    public static RankDTO fromEntity(Rank entity){
        RankDTO tmp = new RankDTO();

        tmp.setRankId(entity.getRankId());
        tmp.setName(entity.getName());
        tmp.setDepartmentId(entity.getDepartment().getDepartmentId());

        return tmp;
    }
}

