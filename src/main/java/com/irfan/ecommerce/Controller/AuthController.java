package com.irfan.ecommerce.Controller;

import com.irfan.ecommerce.Entity.UserEntity;
import com.irfan.ecommerce.Repository.UserRepository;
import com.irfan.ecommerce.DTO.LoginRequestDTO;
import com.irfan.ecommerce.DTO.LoginResponseDTO;
import com.irfan.ecommerce.DTO.RegisterRequestDTO;
import com.irfan.ecommerce.DTO.RegisterResponseDTO;
import com.irfan.ecommerce.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterRequestDTO request) {

        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setAddress(request.getAddress());
        user.setCity(request.getCity());
        user.setState(request.getState());
        user.setPincode(request.getPincode());
        user.setRole("USER");

        UserEntity savedUser = userRepository.save(user);

        RegisterResponseDTO response = new RegisterResponseDTO(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getPhone(),
                savedUser.getAddress(),
                savedUser.getCity(),
                savedUser.getState(),
                savedUser.getPincode(),
                "User registered successfully!"
        );

        return ResponseEntity.ok(response);
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO request) {

        // 1. Verify email & password
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );


        UserEntity user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));


        String token = jwtUtil.generateToken(request.getEmail());


        LoginResponseDTO response = new LoginResponseDTO(
                token,
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole(),
                "Login successful!"
        );

        return ResponseEntity.ok(response);
    }
}
