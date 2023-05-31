package com.airline.service.impl;

import com.airline.dto.userDto.request.UserDtoCreateRequest;
import com.airline.dto.userDto.request.UserDtoPassword;
import com.airline.dto.userDto.request.UserDtoUpdate;
import com.airline.dto.userDto.response.UserDtoResponse;
import com.airline.dto.userDto.response.UserDtoResponseDetail;
import com.airline.entity.Role;
import com.airline.entity.User;
import com.airline.payload.response.checkEmailPassword;
import com.airline.repository.UserRepository;
import com.airline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;

    @Override
    public List<UserDtoResponse> findAll() {
        return null;
    }

    @Override
    public List<UserDtoResponse> getUsersByFullName(String fullName) {
        return null;
    }

    @Override
    public UserDtoResponseDetail getUserById(Long customerId) {
        return null;
    }

    @Override
    public Page<UserDtoResponse> getUsers(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<UserDtoResponse> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public checkEmailPassword save(UserDtoCreateRequest userDtoCreateRequest) {
        return null;
    }

    public void saveNewUser(User user){
        repository.save(user);
    }

    @Override
    public Boolean remove(Long id) {
        return null;
    }

    @Override
    public Boolean updateSimple(String email, UserDtoUpdate userDtoUpdate) {
        return null;
    }

    @Override
    public Boolean updatePassword(String email, UserDtoPassword userDtoPassword) {
        return null;
    }

    @Override
    public Boolean active(Long id) {
        return null;
    }

    @Override
    public UserDtoResponse getUserByEmail(String email) {
        return null;
    }

    @Override
    public Boolean updateAddRole(Long id, Role role) {
        return null;
    }

    @Override
    public Boolean updateRemoveRole(Long userId, Role role) {
        return null;
    }
}
