package com.irfan.ecommerce.Mapper;

import com.irfan.ecommerce.DTO.CreateProductRequestDTO;
import com.irfan.ecommerce.DTO.ProductResponseDTO;
import com.irfan.ecommerce.Entity.ProductEntity;

public class ProductMapper {

    public static ProductEntity toEntity(CreateProductRequestDTO dto) {
        ProductEntity product = new ProductEntity();

        product.setProductName(dto.getName());
        product.setProductDescription(dto.getDescription());
        product.setProductPrice(dto.getPrice());
        product.setProductCategory(dto.getCategory());
        product.setQuantity(dto.getStock());
        return product;
    }

    public ProductResponseDTO convertToDTO(ProductEntity entity) {
        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(entity.getId());
        dto.setProductName(entity.getProductName());
        dto.setProductCategory(entity.getProductCategory());
        dto.setProductPrice(entity.getProductPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setProductDescription(entity.getProductDescription());
        dto.setImage(entity.getImage());

        return dto;
    }
}