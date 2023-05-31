package com.airline.dto.userDto.response;


import com.airline.dto.userRoleDto.response.UserRoleDtoResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDtoResponse {
    private Long id;
    private String fullName;
    private String userName;
    private String email;
    private String avatar;
    private Boolean isStatus;
    private String phone;
    private List<UserRoleDtoResponse> userRoleDtos;
}
