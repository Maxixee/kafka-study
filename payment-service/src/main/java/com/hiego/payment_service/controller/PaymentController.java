package com.hiego.payment_service.controller;

import com.hiego.payment_service.model.Payment;
import com.hiego.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> sendPayment(@RequestBody Payment payment){
        paymentService.sendPayment(payment);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
