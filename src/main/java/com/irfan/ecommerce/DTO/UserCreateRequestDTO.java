package com.irfan.ecommerce.DTO;

import lombok.Data;

@Data
public class UserCreateRequestDTO {
    private String name;
    private String email;
    private String password;

}
