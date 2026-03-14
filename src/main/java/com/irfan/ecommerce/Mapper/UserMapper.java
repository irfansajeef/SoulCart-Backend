package com.irfan.ecommerce.Mapper;

import com.irfan.ecommerce.Entity.UserEntity;
import com.irfan.ecommerce.DTO.UserResponseDTO;

public class UserMapper {
    public static <UserCreateRequestDTO> UserEntity toEntity(com.irfan.ecommerce.DTO.UserCreateRequestDTO dto) {
        UserEntity user = new UserEntity();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

    public static UserResponseDTO toDTO(UserEntity user){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }

}
