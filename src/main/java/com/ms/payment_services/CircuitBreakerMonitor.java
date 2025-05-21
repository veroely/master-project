package com.ms.payment_services;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CircuitBreakerMonitor {

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    public void logState(String circuitName) {
        CircuitBreaker cb = circuitBreakerRegistry.circuitBreaker(circuitName);
        System.out.println("📊 Estado del Circuit Breaker '" + circuitName + "': " + cb.getState());
        System.out.println("📈 Métricas: " + cb.getMetrics().getNumberOfFailedCalls() + " fallos de " + cb.getMetrics().getNumberOfBufferedCalls() + " llamadas");
    }
}