package com.irfan.ecommerce.DTO;

import lombok.Data;

@Data
public class RegisterRequestDTO {
    private String name;
    private String email;
    private String password;
    private Long phone;
    private String address;
    private String city;
    private String state;
    private Integer pincode;
}