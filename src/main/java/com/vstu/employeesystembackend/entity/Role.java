package com.vstu.employeesystembackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id")
    private Long roleId;

    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="roles_authorities",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name="authority_id")
    )
    private Collection<Authority> authorities = new ArrayList();

    public Role(String name){
        this.name = name;
    }

}
