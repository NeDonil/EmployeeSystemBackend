package com.vstu.employeesystembackend.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Rank {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name="rank_id")
    private Long rankId;

    private String name;

    @OneToOne
    @JoinColumn(name="department_id", referencedColumnName = "department_id")
    private Department departmentId;
}
