package com.vstu.employeesystembackend.dto;

import com.vstu.employeesystembackend.entity.Vacation;
import lombok.Data;

import java.time.LocalDate;

@Data
public class VacationDTO {
    private Long vacationId;

    private LocalDate beginDate;

    private LocalDate endDate;

    private Long employeeId;

    public static VacationDTO fromEntity(Vacation entity){
        VacationDTO tmp = new VacationDTO();

        tmp.setVacationId(entity.getVacationId());
        tmp.setBeginDate(entity.getBeginDate());
        tmp.setEndDate(entity.getEndDate());
        tmp.setEmployeeId(entity.getEmployee().getEmployeeId());

        return tmp;
    }
}
