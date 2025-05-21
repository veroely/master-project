package com.ms.payment_services.domain;

public sealed interface PaymentDetails {
    record CardDetails(
        String cardNumber,
        String cardHolderName,
        String expirationDate,
        String cvv
    ) implements PaymentDetails {}

    record BankAccountDetails(
        String accountNumber,
        String bankCode,
        String accountType
    ) implements PaymentDetails {}
}
