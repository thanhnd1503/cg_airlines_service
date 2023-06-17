package com.airline.service.impl;

import com.airline.converter.UserConverter;
import com.airline.dto.userDto.request.UserDtoCreateRequest;
import com.airline.dto.userDto.request.UserDtoPassword;
import com.airline.dto.userDto.request.UserDtoUpdate;
import com.airline.dto.userDto.response.UserDtoResponse;
import com.airline.dto.userDto.response.UserDtoResponseDetail;
import com.airline.entity.Role;
import com.airline.entity.User;
import com.airline.entity.UserRole;
import com.airline.payload.response.checkEmailPassword;
import com.airline.repository.RoleRepository;
import com.airline.repository.UserRepository;
import com.airline.repository.UserRoleRepository;
import com.airline.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final RoleRepository roleRepository;
    private final UserConverter userConverter;

    @Autowired
    UserRepository repository;

    public UserServiceImpl(UserRepository userRepository, UserRoleRepository userRoleRepository, RoleRepository roleRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.roleRepository = roleRepository;
        this.userConverter = userConverter;
    }

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
        User email = userRepository.findUserByEmail(userDtoCreateRequest.getEmail());
        User userName = userRepository.findUserByUserName(userDtoCreateRequest.getUserName());
        checkEmailPassword checkEmailPassword = new checkEmailPassword();
        if (email != null && userName != null) {
            checkEmailPassword.setUserName("userName already exists");
            checkEmailPassword.setEmail("email already exists");
            return checkEmailPassword;
        } else if (email == null && userName != null) {
            checkEmailPassword.setUserName("userName already exists");
            return checkEmailPassword;
        } else if (email != null && userName == null) {
            checkEmailPassword.setEmail("email already exists");
            return checkEmailPassword;
        } else {
            User newUser = userConverter.dtoToEntity(userDtoCreateRequest);
            String hashedPassword = BCrypt.hashpw(userDtoCreateRequest.getPassword(), BCrypt.gensalt(10));
            newUser.setPassword(hashedPassword);

            userRepository.save(newUser);

                Role role = new Role(2,"ROLE_CUSTOMER","khách hàng");
                UserRole userRole = new UserRole(newUser, role);
                userRoleRepository.save(userRole);


            return null;
        }
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

    @Override
    public List<String> getRoleByUserName(String userName) {
            List<String> roles = userRepository.findRolesByUserName(userName);
        return roles;
    }
}
