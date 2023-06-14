//package com.airline.controller;
//
//
//import com.airline.service.SecurityService;
//import com.airline.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@CrossOrigin(value = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/api/user")
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private SecurityService securityService;
//
//    @GetMapping
//    public ResponseEntity<?> getUsers(@RequestHeader("Authorization") final String authToken) {
//        if (!securityService.isAuthenticated() && !securityService.isValidToken(authToken)) {
//            return new ResponseEntity<String>("Responding with unauthorized error. Message - {}", HttpStatus.UNAUTHORIZED);
//        }
//        List<UserDto> userDtos = userService.getUsers();
//        if (userDtos.isEmpty()) {
//            return new ResponseEntity<List<UserDto>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(userDtos, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getOne(@PathVariable("id") Integer id,
//                                    @RequestHeader("Authorization") final String authToken) {
//        if (!securityService.isAuthenticated() && !securityService.isValidToken(authToken)) {
//            return new ResponseEntity<String>("Responding with unauthorized error. Message - {}", HttpStatus.UNAUTHORIZED);
//        }
//        UserDto userDto = userService.getUserById(id);
//        if (userDto == null) {
//            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(userDto, HttpStatus.OK);
//    }
//
//    @PostMapping("/search")
//    public ResponseEntity<?> search(@RequestBody SearchRequest searchRequest,
//                                    @RequestHeader("Authorization") final String authToken) {
//        if (!securityService.isAuthenticated() && !securityService.isValidToken(authToken)) {
//            return new ResponseEntity<String>("Responding with unauthorized error. Message - {}", HttpStatus.UNAUTHORIZED);
//        }
//        List<UserDto> userDtos = null;
//        if (searchRequest.getKeyword() != null && !searchRequest.getKeyword().isEmpty()) {
//            userDtos = userService.getUsersByFullName(searchRequest.getKeyword());
//            if (userDtos.isEmpty()) {
//                return new ResponseEntity<List<UserDto>>(HttpStatus.NO_CONTENT);
//            }
//        }
//        return new ResponseEntity<>(userDtos, HttpStatus.OK);
//    }
//}