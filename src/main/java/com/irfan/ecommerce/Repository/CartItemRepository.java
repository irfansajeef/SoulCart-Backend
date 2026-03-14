package com.irfan.ecommerce.Repository;

import com.irfan.ecommerce.Entity.CartEntity; // Added import
import com.irfan.ecommerce.Entity.CartItemEntity;
import com.irfan.ecommerce.Entity.ProductEntity; // Added import
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional; // Added import

@Repository
public interface CartItemRepository extends JpaRepository<CartItemEntity, Long> {

    List<CartItemEntity> findByCart_UserId(Long userId);


    Optional<CartItemEntity> findByCartAndProduct(CartEntity cart, ProductEntity product);
}