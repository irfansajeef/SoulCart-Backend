package com.irfan.ecommerce.DTO;

import lombok.Data;

@Data
public class PaymentRequestDTO {
    private Long userId;
    private Double amount;
    private String paymentMethod;
}