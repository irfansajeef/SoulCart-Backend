package com.irfan.ecommerce.Service;

import com.irfan.ecommerce.Entity.ProductEntity;
import com.irfan.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public ProductEntity addProduct(ProductEntity product) {
        return productRepository.save(product);
    }


    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }


    public ProductEntity getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }


    public ProductEntity UpdateProduct(Long id, ProductEntity updatedProduct) {

        ProductEntity product = getProductById(id);

        product.setProductName(updatedProduct.getProductName());
        product.setProductDescription(updatedProduct.getProductDescription());
        product.setProductPrice(updatedProduct.getProductPrice());
        product.setProductCategory(updatedProduct.getProductCategory());

        return productRepository.save(product);
    }


    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}