package com.ms.payment_services.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ElectricPayment(
    String reference,
    BigDecimal amount,
    LocalDateTime paymentDate,
    PaymentMethod paymentMethod,
    PaymentDetails paymentDetails
) {}
