package com.airline.controller.controller_FE_SF;

import com.airline.dto.passengerDto.request.PassengerDtoRequest;
import com.airline.service.PassengerService;
import com.airline.service.SecurityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class PassengerController {
    @Autowired
    PassengerService service;
    @Autowired
    private SecurityService securityService;
    @PostMapping("/passenger")
    public ResponseEntity<?> SavePass(@RequestBody PassengerDtoRequest passengerDtoRequest){
//        if (!securityService.isAuthenticated()) {
//            return new ResponseEntity<String>("Responding with unauthorized error. Message - {}", HttpStatus.UNAUTHORIZED);
//        }
        service.save(passengerDtoRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
