package com.ms.payment_services.dto;

import lombok.Data;

@Data
public class ElectricPaymentRequest {
    private String reference;
    private Double amount;
    private String dueDate;
}
