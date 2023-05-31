package com.airline.converter;

import com.airline.dto.roleDto.response.RoleDtoResponse;
import com.airline.entity.Role;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {
    public RoleDtoResponse entityToDto(Role role){
        RoleDtoResponse roleDtoResponse = new RoleDtoResponse();
        BeanUtils.copyProperties(role, roleDtoResponse);
        return roleDtoResponse;
    }
}
