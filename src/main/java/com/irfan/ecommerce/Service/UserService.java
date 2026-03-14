package com.irfan.ecommerce.Service;


import com.irfan.ecommerce.Entity.UserEntity;
import com.irfan.ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }


    public UserEntity register(UserEntity user){

        return userRepository.save(user);
    }


    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }


    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }


    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}