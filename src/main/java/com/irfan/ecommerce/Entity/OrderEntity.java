package com.irfan.ecommerce.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long Userid;
    private double totalamount;
    private String orderstatus;
    private  String paymentstatus;
    private String status;
    private String address;
    private LocalDateTime orderdate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItems;

    public void setTotalAmount(double total) {

    }
}