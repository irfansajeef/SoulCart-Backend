package com.irfan.ecommerce.Controller;

import com.irfan.ecommerce.Entity.ProductEntity;
import com.irfan.ecommerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/addproducts")
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productService.addProduct(product);
    }

    @GetMapping
    public List<ProductEntity> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductEntity getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductEntity updateProduct(@PathVariable Long id, @RequestBody ProductEntity product) {
        return productService.UpdateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully";
    }
}
