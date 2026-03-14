package com.irfan.ecommerce.DTO;

import lombok.Data;

@Data
public class CreateProductRequestDTO {

    private String Name;
    private String Description;
    private String Category;
    private int Price;
    private int Stock;

}

