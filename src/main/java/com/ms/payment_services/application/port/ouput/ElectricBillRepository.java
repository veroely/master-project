package com.ms.payment_services.application.port.ouput;

import com.ms.payment_services.domain.ElectricBill;
import com.ms.payment_services.domain.ElectricPayment;

public interface ElectricBillRepository {
    ElectricBill findByReference(String reference);
    ElectricPayment processPayment(ElectricPayment electricPayment);
}
