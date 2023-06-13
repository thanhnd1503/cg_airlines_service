package com.airline.controller.controller_FE_SF;

import com.airline.dto.bookTicketsDto.request.BookTicketDtoRequest;
import com.airline.dto.bookTicketsDto.response.BookTicketDtoResponse;
import com.airline.service.BookTicketService;
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
    BookTicketService service;
    @PostMapping("/book")
    public ResponseEntity<?> BookTicket(@Valid @RequestBody BookTicketDtoRequest bookTicketDtoRequest){
        service.save(bookTicketDtoRequest);
        BookTicketDtoResponse bookTicketDtoResponse = service.getOrderTicket(bookTicketDtoRequest);
        return new ResponseEntity<>(bookTicketDtoResponse, HttpStatus.OK);
    }
}
