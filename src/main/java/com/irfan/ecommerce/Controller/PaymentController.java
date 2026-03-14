package com.irfan.ecommerce.Controller;

import com.irfan.ecommerce.DTO.PaymentRequestDTO;
import com.irfan.ecommerce.Entity.PaymentEntity;
import com.irfan.ecommerce.Service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/pay")
    public ResponseEntity<PaymentEntity> pay(@RequestBody PaymentRequestDTO request) {
        PaymentEntity result = paymentService.processPayment(request);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PaymentEntity>> getPayments(@PathVariable Long userId) {
        return ResponseEntity.ok(paymentService.getPaymentsByUser(userId));
    }
}
