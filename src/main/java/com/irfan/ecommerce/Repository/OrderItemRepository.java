package com.irfan.ecommerce.Repository;

import com.irfan.ecommerce.Entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Long> {
}
