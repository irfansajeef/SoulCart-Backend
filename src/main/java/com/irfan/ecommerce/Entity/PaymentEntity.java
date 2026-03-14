package com.irfan.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Double amount;
    private String paymentMethod;

    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    private String transactionId;
    private LocalDateTime paymentTime;

    public enum PaymentStatus {
        PENDING, SUCCESS, FAILED
    }
}