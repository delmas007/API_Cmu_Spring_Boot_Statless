package com.example.cmuspring.Dto;

import com.example.cmuspring.Model.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleDto {

    private String role;

    public static RoleDto fromEntity(Role role){
        if (role == null){
            return null;
        }
        return RoleDto.builder()
                .role(role.getRole())
                .build();
    }

    public static Role toEntity(RoleDto roleDto){
        if (roleDto == null){
            return null;
        }
        return Role.builder()
                .role(roleDto.getRole())
                .build();
    }
}
