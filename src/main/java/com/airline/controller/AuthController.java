package com.airline.controller;

import com.airline.dto.userDto.request.UserDtoCreateRequest;
import com.airline.payload.request.LoginRequest;
import com.airline.payload.response.LoginResponse;
import com.airline.payload.response.checkEmailPassword;
import com.airline.service.AuthService;
import com.airline.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin ("*")
@RestController
@RequestMapping ("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse loginResponse = authService.login(loginRequest);
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("this Account is not valid", HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    public ResponseEntity<?> create(@Validated @RequestBody UserDtoCreateRequest userDtoCreateRequest) {
        checkEmailPassword checkEmailPassword = userService.save(userDtoCreateRequest);
        if (checkEmailPassword == null) {
            return new ResponseEntity<>(null, HttpStatus.OK);
        } else return new ResponseEntity<>(checkEmailPassword, HttpStatus.BAD_REQUEST);
    }
    @GetMapping
    public ResponseEntity<?> findUserByAccount(@Valid @RequestParam String account) {
        try {
            Boolean isExist = authService.isExistAccount(account);
            return new ResponseEntity<>(isExist, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
