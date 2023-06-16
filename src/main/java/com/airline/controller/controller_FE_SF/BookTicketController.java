package com.airline.controller.controller_FE_SF;

import com.airline.dto.bookTicketsDto.request.BookTicketDtoRequest;
import com.airline.dto.bookTicketsDto.response.BookTicketDtoResponse;
import com.airline.service.BookTicketService;
import com.airline.service.SecurityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class BookTicketController {
    @Autowired
    BookTicketService bookTicketService;
    @Autowired
    SecurityService securityService;
    @PostMapping("/book")
    public ResponseEntity<?> BookTicket(@Valid @RequestBody BookTicketDtoRequest bookTicketDtoRequest){
        if (!securityService.isAuthenticated()) {
            return new ResponseEntity<String>("Responding with unauthorized error. Message - {}", HttpStatus.UNAUTHORIZED);
        }
        bookTicketService.save(bookTicketDtoRequest);
        BookTicketDtoResponse bookTicketDtoResponse = bookTicketService.getOrderTicket(bookTicketDtoRequest);
        return new ResponseEntity<>(bookTicketDtoResponse, HttpStatus.OK);
    }
    
//    @GetMapping
//    public ResponseEntity<?> getBookTicket() {
//        bookTicketService.getOrderTicket();
//    }
}
