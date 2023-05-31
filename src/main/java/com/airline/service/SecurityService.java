package com.airline.service;

public interface SecurityService {
    boolean isAuthenticated();
    boolean isValidToken(String token);
}
