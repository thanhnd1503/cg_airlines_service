package com.airline.service.impl;

import com.airline.converter.UserConverter;
import com.airline.dto.userDto.response.UserDtoResponse;
import com.airline.entity.User;
import com.airline.payload.request.LoginRequest;
import com.airline.payload.response.LoginResponse;
import com.airline.repository.UserRepository;
import com.airline.security.JwtTokenProvider;
import com.airline.service.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final JwtTokenProvider tokenProvider;
    private final UserConverter userConverter;

    public AuthServiceImpl(UserRepository userRepository, JwtTokenProvider tokenProvider, AuthenticationManager authenticationManager, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.tokenProvider = tokenProvider;
        this.authenticationManager = authenticationManager;
        this.userConverter = userConverter;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User currentUser = userRepository.findUserByAccount(loginRequest.getAccount());
        UserDtoResponse userDtoResponse = userConverter.entityToDto(currentUser);
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        userDtoResponse.getUserName(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Gọi hàm tạo Token
        String token = tokenProvider.generateToken(authentication);
        LoginResponse loginResponse = new LoginResponse(userDtoResponse, token);
        return loginResponse;
    }
    @Override
    public Boolean isExistAccount (String account){
        UserDtoResponse userDtoResponse = userConverter.entityToDto(userRepository.findUserByAccount(account));
        if( userDtoResponse != null) return true;
        else return false;
    }
}

