package com.vstu.employeesystembackend.dto;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Authority {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name="authority_id")
    private Long authorityId;

    private String name;

    public Authority(String name){
        this.name = name;
    }
}
