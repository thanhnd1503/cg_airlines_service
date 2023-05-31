package com.airline.payload.response;

import com.airline.entity.UserRole;
import lombok.Data;

import java.util.List;

@Data
public class UserDtoResponse {
    private Long id;
    private String userName;
    private String email;
    private String phone;
    private List<UserRole> userRoles;
}
