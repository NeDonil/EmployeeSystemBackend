package com.vstu.employeesystembackend.dto;

import com.vstu.employeesystembackend.entity.Payment;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class PaymentDTO {

    private Long paymentId;
    private String name;
    private double paidAmount;

    public static PaymentDTO fromEntity(Payment entity){
        PaymentDTO tmp = new PaymentDTO();

        tmp.setPaymentId(entity.getPaymentId());
        tmp.setName(entity.getName());
        tmp.setPaidAmount(entity.getPaidAmount());

        return tmp;
    }
}
