package com.ms.payment_services.infrastructure.adapter.rest;

import com.ms.payment_services.application.service.ElectricBillService;
import com.ms.payment_services.domain.ElectricBill;
import com.ms.payment_services.infrastructure.adapter.mapper.ElectricMapper;
import com.ms.payment_services.infrastructure.adapter.rest.dto.ElectricBillResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/electricity")
public class ElectricBillController {
    private final ElectricBillService electricBillService;
    private final ElectricMapper mapper;

    public ElectricBillController(ElectricBillService electricBillService, ElectricMapper mapper) {
        this.electricBillService = electricBillService;
        this.mapper = mapper;
    }

    @GetMapping("/bill/{reference}")
    public ElectricBillResponse getBill(@PathVariable String reference) {
        ElectricBill bill = electricBillService.getBill(reference);
        return mapper.toElectricBillResponse(bill);
    }
}
