package com.vstu.employeesystembackend.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Payment {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "payment_id")

    private Long paymentId;

    private String name;

    @Column(name = "paid_amount")
    private double paidAmount;
}
