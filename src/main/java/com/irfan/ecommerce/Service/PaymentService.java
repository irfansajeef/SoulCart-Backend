package com.irfan.ecommerce.Service;

import com.irfan.ecommerce.DTO.PaymentRequestDTO;
import com.irfan.ecommerce.Entity.PaymentEntity;
import com.irfan.ecommerce.Entity.PaymentEntity.PaymentStatus;
import com.irfan.ecommerce.Repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentEntity processPayment(PaymentRequestDTO request) {
        PaymentEntity payment = new PaymentEntity();
        payment.setUserId(request.getUserId());
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setPaymentTime(LocalDateTime.now());
        payment.setTransactionId("TXN-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());

        // 90% success rate mock
        double random = Math.random();
        if (random <= 0.9) {
            payment.setStatus(PaymentStatus.SUCCESS);
        } else {
            payment.setStatus(PaymentStatus.FAILED);
        }

        return paymentRepository.save(payment);
    }

    public List<PaymentEntity> getPaymentsByUser(Long userId) {
        return paymentRepository.findByUserId(userId);
    }
}
