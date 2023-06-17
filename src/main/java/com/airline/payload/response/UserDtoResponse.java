package com.airline.payload.response;

import com.airline.entity.UserRole;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class UserDtoResponse {
    private Long id;
    private String userName;
    private String email;
    private String phone;
    private List<UserRole> userRoles;
}
