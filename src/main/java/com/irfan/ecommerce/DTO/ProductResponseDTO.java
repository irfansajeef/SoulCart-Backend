package com.irfan.ecommerce.DTO;

import lombok.Data;

@Data
public class ProductResponseDTO {
    private int id;
    private String productName;
    private String productCategory;
    private int productPrice;
    private int quantity;
    private String productDescription;
    private String image;
}