package com.ms.payment_services.infrastructure.adapter.mapper;

import com.ms.payment_services.domain.ElectricBill;
import com.ms.payment_services.domain.ElectricPayment;
import com.ms.payment_services.dto.ElectricPaymentRequest;
import com.ms.payment_services.dto.ElectricPaymentResponse;
import com.ms.payment_services.infrastructure.adapter.rest.dto.ElectricBillResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ElectricMapper {
    @Mapping(target = "reference", source = "reference")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "dueDate", source = "dueDate", dateFormat = "yyyy-MM-dd")
    ElectricBill toElectricBill(ElectricBillResponse billResponse);

    @Mapping(target = "reference", source = "reference")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "dueDate", source = "dueDate", dateFormat = "yyyy-MM-dd")
    ElectricBillResponse toElectricBillResponse(ElectricBill bill);

    @Mapping(target = "reference", source = "paymentReference")
    @Mapping(target = "amount", source = "amount")
    //@Mapping(target = "paymentDate", source = "paymentDate")
    @Mapping(target = "paymentMethod", constant = "CREDIT_CARD")
    //@Mapping(target = "paymentDetails", constant = "{}")
    ElectricPayment toElectricPayment(ElectricPaymentResponse paymentResponse);

    @Mapping(target = "paymentReference", source = "reference")
    @Mapping(target = "amount", source = "amount")
    ElectricPaymentResponse toElectricPaymentResponse(ElectricPayment payment);

    @Mapping(target = "reference", source = "reference")
    @Mapping(target = "amount", source = "amount")
    //@Mapping(target = "paymentDate", source = "paymentDate")
    ElectricPaymentRequest toElectricPaymentRequest(ElectricPayment payment);

    @Mapping(target = "reference", source = "reference")
    @Mapping(target = "amount", source = "amount")
    //@Mapping(target = "paymentDate", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "paymentMethod", constant = "CREDIT_CARD")
    //@Mapping(target = "paymentDetails", constant = "{}")
    ElectricPayment toElectricPayment(ElectricPaymentRequest request);

    default BigDecimal toBigDecimal(Double value) {
        return value == null ? BigDecimal.ZERO : BigDecimal.valueOf(value);
    }

    default Double toDouble(BigDecimal value) {
        return value == null ? 0.0 : value.doubleValue();
    }

    default LocalDateTime toLocalDateTime(String dateStr) {
        return dateStr == null ? null : LocalDateTime.parse(dateStr);
    }

    default String toString(LocalDateTime dateTime) {
        return dateTime == null ? null : dateTime.toString();
    }
}
