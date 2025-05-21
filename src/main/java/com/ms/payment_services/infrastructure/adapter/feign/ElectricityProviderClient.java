package com.ms.payment_services.infrastructure.adapter.feign;

import com.ms.payment_services.dto.ElectricPaymentRequest;
import com.ms.payment_services.dto.ElectricPaymentResponse;
import com.ms.payment_services.infrastructure.adapter.rest.dto.ElectricBillResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "electricityProvider", url = "${external-services.electricity-provider.url}")
public interface ElectricityProviderClient {

    @GetMapping("/api/electricity/bill")
    ElectricBillResponse getBill(@RequestParam("reference") String reference);

    @PostMapping("/api/electricity/payment")
    ElectricPaymentResponse processPayment(ElectricPaymentRequest bill);
}
