package com.irfan.ecommerce.Repository;

import com.irfan.ecommerce.Entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    List<PaymentEntity> findByUserId(Long userId);
}