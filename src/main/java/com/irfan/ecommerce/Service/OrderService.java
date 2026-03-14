package com.irfan.ecommerce.Service;

import com.irfan.ecommerce.Entity.OrderEntity;
import com.irfan.ecommerce.Repository.OrderRepository;
import com.irfan.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    public OrderEntity placeOrder(OrderEntity order) {
        return null;
    }


    public List<OrderEntity> getAllOrders() {
        return orderRepository.findAll();
    }


    public OrderEntity getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }


    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public List<OrderEntity> getOrdersByUser(Long userId) {
        return null;
    }

    public OrderEntity updateOrderStatus(Long id, String status) {
     return null;}
    }
