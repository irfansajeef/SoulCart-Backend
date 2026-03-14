package com.irfan.ecommerce.Repository;

import com.irfan.ecommerce.Entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
