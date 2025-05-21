package com.ms.payment_services.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ElectricBill(String reference, BigDecimal amount, LocalDate dueDate) {}
