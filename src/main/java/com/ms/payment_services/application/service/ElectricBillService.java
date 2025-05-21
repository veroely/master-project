package com.ms.payment_services.application.service;

import com.ms.payment_services.application.port.ouput.ElectricBillRepository;
import com.ms.payment_services.domain.ElectricBill;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ElectricBillService {
    private final ElectricBillRepository electricBillRepository;

    public ElectricBillService(
            ElectricBillRepository electricBillRepository) {
        this.electricBillRepository = electricBillRepository;
    }

    @CircuitBreaker(name = "getBill", fallbackMethod = "getBillFallback")
    public ElectricBill getBill(String reference) {
        return electricBillRepository.findByReference(reference);
    }

    public ElectricBill getBillFallback(String reference, Exception e) {
        return new ElectricBill(
            reference,
            BigDecimal.ZERO,
            java.time.LocalDate.now()
        );
    }
}
