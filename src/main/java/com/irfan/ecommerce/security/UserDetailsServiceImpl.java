package com.irfan.ecommerce.security;

import com.irfan.ecommerce.Entity.UserEntity;
import com.irfan.ecommerce.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {


        UserEntity userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));


        return User.builder()
                .username(userEntity.getEmail())
                .password(userEntity.getPassword())
                .roles(userEntity.getRole()) // "USER" or "ADMIN"
                .build();
    }
}