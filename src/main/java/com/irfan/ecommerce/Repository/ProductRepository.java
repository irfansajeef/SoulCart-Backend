package com.irfan.ecommerce.Repository;

import com.irfan.ecommerce.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <ProductEntity,Long>{
}