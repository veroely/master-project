package com.ms.payment_services.infrastructure.adapter.rest.dto;

public record ElectricBillResponse(String reference, double amount, String dueDate) {
}
