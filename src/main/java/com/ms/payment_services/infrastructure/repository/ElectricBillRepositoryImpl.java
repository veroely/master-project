package com.ms.payment_services.infrastructure.repository;

import com.ms.payment_services.application.port.ouput.ElectricBillRepository;
import com.ms.payment_services.domain.ElectricBill;
import com.ms.payment_services.domain.ElectricPayment;
import com.ms.payment_services.dto.ElectricPaymentRequest;
import com.ms.payment_services.dto.ElectricPaymentResponse;
import com.ms.payment_services.infrastructure.adapter.feign.ElectricityProviderClient;
import com.ms.payment_services.infrastructure.adapter.mapper.ElectricMapper;
import com.ms.payment_services.infrastructure.adapter.rest.dto.ElectricBillResponse;
import org.springframework.stereotype.Repository;

@Repository
public class ElectricBillRepositoryImpl implements ElectricBillRepository {
    private final ElectricityProviderClient electricityProviderClient;
    private final ElectricMapper mapper;

    public ElectricBillRepositoryImpl(ElectricityProviderClient electricityProviderClient, ElectricMapper mapper) {
        this.electricityProviderClient = electricityProviderClient;
        this.mapper = mapper;
    }

    @Override
    public ElectricBill findByReference(String reference) {
        ElectricBillResponse billResponse = electricityProviderClient.getBill(reference);
        return mapper.toElectricBill(billResponse);
    }

    @Override
    public ElectricPayment processPayment(ElectricPayment electricPayment) {
        ElectricPaymentRequest payment = mapper.toElectricPaymentRequest(electricPayment);
        ElectricPaymentResponse response = electricityProviderClient.processPayment(payment);
        return mapper.toElectricPayment(response);
    }
}
