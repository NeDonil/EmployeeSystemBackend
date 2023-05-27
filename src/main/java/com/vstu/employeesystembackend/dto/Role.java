package com.vstu.employeesystembackend.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id")
    private Long roleId;

    private String name;

    @ManyToMany
    @JoinTable(name="roles_authorities",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name="authority_id")
    )
    private Collection<Authority> authorities = new ArrayList();

    public Role(String name){
        this.name = name;
    }

}
