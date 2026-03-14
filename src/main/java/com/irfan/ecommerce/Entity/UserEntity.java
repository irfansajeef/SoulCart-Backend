package com.irfan.ecommerce.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private Long phone;
    private String address;
    private String city;
    private String state;
    private Integer pincode;

    @OneToMany(mappedBy = "user")
    private List<OrderEntity> orders;


}
