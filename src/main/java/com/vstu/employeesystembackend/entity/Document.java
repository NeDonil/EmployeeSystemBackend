package com.vstu.employeesystembackend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Document {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name="document_id")
    private Long documentId;

    private String documentName;
    private String documentCode;
}
