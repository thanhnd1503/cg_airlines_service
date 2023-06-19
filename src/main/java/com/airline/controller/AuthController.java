package com.airline.controller;

import com.airline.dto.userDto.request.UserDtoCreateRequest;
import com.airline.payload.request.LoginRequest;
import com.airline.payload.response.LoginResponse;
import com.airline.payload.response.checkEmailPassword;
import com.airline.service.AuthService;
import com.airline.service.SecurityService;
import com.airline.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthService authService;
    @Autowired
    private SecurityService securityService;


    @GetMapping("/access-denied")
    public ResponseEntity<?> getAccessDenied(){
        return new ResponseEntity<>("Access denied!", HttpStatus.FORBIDDEN);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
//        if (securityService.isAuthenticated()) {
//            return new ResponseEntity<String>("Responding with unauthorized error. Message - {}", HttpStatus.UNAUTHORIZED);
//        }
        try {
            LoginResponse loginResponse = authService.login(loginRequest);
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("this Account is not valid", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
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
//package com.airline.controller;
//
//
//import com.airline.payload.request.LoginRequest;
//import com.airline.payload.response.LoginResponse;
//import com.airline.security.JwtTokenProvider;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//
//
//@CrossOrigin(value = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    PasswordEncoder passwordEncoder;
//
//    @Autowired
//    JwtTokenProvider tokenProvider;
//
//    @PostMapping("/login")
//    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
//        try {
//            // Gọi hàm authenticate để xác thực thông tin đăng nhập
//            Authentication authentication = authenticationManager
//                    .authenticate(new UsernamePasswordAuthenticationToken(
//                            loginRequest.getAccount(), loginRequest.getPassword()));
//
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//
//            // Gọi hàm tạo Token
//            String token = tokenProvider.generateToken(authentication);
//            return new ResponseEntity<>(new LoginResponse("Đăng nhập thành công!", token), HttpStatus.OK);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ResponseEntity<>(new LoginResponse("Đăng nhập thất bại!", null), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/access-denied")
//    public ResponseEntity<?> getAccessDenied() {
//        return new ResponseEntity<>("Không có quyền truy cập!", HttpStatus.FORBIDDEN);
//    }
//}