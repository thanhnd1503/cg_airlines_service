package com.airline.converter;

import com.airline.dto.userDto.request.UserDtoCreateRequest;
import com.airline.dto.userDto.response.UserDtoResponse;
import com.airline.dto.userDto.response.UserDtoResponseDetail;
import com.airline.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserConverter {
    private final UserRoleConverter userRoleConverter;
    public Optional<UserDtoResponse> entityToDtoOptional(Optional<User> user ){
        Optional<UserDtoResponse> userDtoResponse = Optional.of(new UserDtoResponse());
        BeanUtils.copyProperties(user,userDtoResponse);
        return userDtoResponse;
    }
    public UserDtoResponse entityToDto(User user){
        UserDtoResponse userDtoResponse = new UserDtoResponse();
        BeanUtils.copyProperties(user, userDtoResponse);
        userDtoResponse.setUserRoleDtos(userRoleConverter.entitiesToDtos(user.getUserRoles()));
        return userDtoResponse;
    }
    public User dtoToEntity(UserDtoCreateRequest userDtoCreateRequest){
        User user = new User();
        BeanUtils.copyProperties(userDtoCreateRequest, user);
        return user;
    }
    public User dtoToEntity(UserDtoCreateRequest userDtoCreateRequest, User user){
        BeanUtils.copyProperties(userDtoCreateRequest, user);
        return user;
    }

    public UserDtoResponseDetail entityToUserDtoResponseDetail(User user){
        UserDtoResponseDetail userDtoResponseDetail = new UserDtoResponseDetail();
        BeanUtils.copyProperties(user, userDtoResponseDetail);
        userDtoResponseDetail.setUserRoleDtos(userRoleConverter.entitiesToDtoResponseDetails(user.getUserRoles()));
        return userDtoResponseDetail;
    }


}
