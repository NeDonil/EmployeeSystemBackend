package com.vstu.employeesystembackend.dto;

import com.vstu.employeesystembackend.entity.Task;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private Long taskId;
    private String name;
    private String description;
    private LocalDateTime startline;
    private LocalDateTime deadline;
    private String completeStage;
    private Long employeeId;

    public static TaskDTO fromEntity(Task entity){
        TaskDTO tmp = new TaskDTO();

        tmp.setTaskId(entity.getTaskId());
        tmp.setName(entity.getName());
        tmp.setDescription(entity.getDescription());
        tmp.setStartline(entity.getStartline());
        tmp.setDeadline(entity.getDeadline());
        tmp.setCompleteStage(entity.getCompleteStage());
        tmp.setEmployeeId(entity.getEmployee().getEmployeeId());

        return tmp;
    }



}
