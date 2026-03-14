package com.irfan.ecommerce.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {
    private String token;
    private Long userId;
    private String name;
    private String email;
    private String role;
    private String message;
}