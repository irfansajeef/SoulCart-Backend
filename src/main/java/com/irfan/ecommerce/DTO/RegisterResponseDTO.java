package com.irfan.ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterResponseDTO {
    private Long id;
    private String name;
    private String email;
    private Long phone;
    private String address;
    private String city;
    private String state;
    private Integer pincode;
    private String message;
}