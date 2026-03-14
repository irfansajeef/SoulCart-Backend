package com.irfan.ecommerce.Controller;

import com.irfan.ecommerce.Entity.OrderEntity;
import com.irfan.ecommerce.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/addorders")
    public OrderEntity placeOrder(@RequestBody OrderEntity orderEntity) {
        return orderService.placeOrder(orderEntity);
    }

    @GetMapping("/{id}")
    public OrderEntity getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping
    public List<OrderEntity> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/user/{userId}")
    public List<OrderEntity> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUser(userId);
    }

    @PutMapping("/{id}")
    public OrderEntity updateOrderStatus(
            @PathVariable Long id,
            @RequestBody OrderEntity orderEntity) {


        String status = orderEntity.getStatus();
        return orderService.updateOrderStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return "Order with ID " + id + " has been deleted";
    }
}