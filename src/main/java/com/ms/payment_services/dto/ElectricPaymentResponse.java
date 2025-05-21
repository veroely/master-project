package com.ms.payment_services.dto;

import lombok.Data;

@Data
public class ElectricPaymentResponse {
    private String status;
    private String message;
    private String paymentReference;
    private Double amount;
    private String providerTrackingId;
}
