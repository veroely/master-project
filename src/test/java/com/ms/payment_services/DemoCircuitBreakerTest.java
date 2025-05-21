package com.ms.payment_services;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoCircuitBreakerTest {

//    @Autowired
//    private PaymentService paymentService;
//
//    @Autowired
//    private CircuitBreakerRegistry circuitBreakerRegistry;
//
//    @Test
//    void forceCircuitBreakerToOpen() {
//        for (int i = 0; i < 15; i++) {
//            try {
//                paymentService.sayHello();
//            } catch (Exception e) {
//                System.out.println("Call " + i + " failed: " + e.getMessage());
//            }
//        }
//
//        var state = circuitBreakerRegistry.circuitBreaker("helloService").getState();
//        System.out.println("Circuit breaker state: " + state);
//    }
}
