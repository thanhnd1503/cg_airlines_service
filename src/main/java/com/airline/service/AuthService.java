package com.airline.service;


import com.airline.payload.request.LoginRequest;
import com.airline.payload.response.LoginResponse;

public interface AuthService {
    LoginResponse login (LoginRequest loginRequest);
    Boolean isExistAccount (String account);
}
