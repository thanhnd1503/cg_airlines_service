package com.airline.controller.controller_FE_SF;

import com.airline.dto.bookTicketsDto.request.BookTicketDtoRequest;
import com.airline.dto.bookTicketsDto.response.BookTicketDtoResponse;
import com.airline.entity.Passenger;
import com.airline.entity.Ticket;
import com.airline.repository.BookTicketRepository;
import com.airline.repository.PassengerRepository;
import com.airline.repository.TicketRepository;
import com.airline.service.BookTicketService;
import com.airline.service.PassengerService;
import com.airline.service.SecurityService;
import com.airline.service.TicketService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/users")
public class BookTicketController {
    @Autowired
    BookTicketService bookTicketService;
    @Autowired
    SecurityService securityService;
    @Autowired
    TicketService ticketService;
    @Autowired
    PassengerService passengerService;

    @PostMapping("/{user-id}/book")
    public ResponseEntity<?> BookTicket(@Valid @RequestBody BookTicketDtoRequest bookTicketDtoRequest,@PathVariable("user-id") Long userId){
        if (!securityService.isAuthenticated()) {
            return new ResponseEntity<String>("Responding with unauthorized error. Message - {}", HttpStatus.UNAUTHORIZED);
        }
        Long orderId = bookTicketService.save(bookTicketDtoRequest,userId);

        BookTicketDtoResponse bookTicketDtoResponse = bookTicketService.getOrderTicket(orderId);
        List<Ticket> tickets = ticketService.getTicketByOrders(bookTicketService.findById(orderId));
        System.out.println(tickets.size());
        List<Passenger> passengers = passengerService.findAllByOrders(bookTicketService.findById(orderId));
        System.out.println(passengers.size());
        bookTicketDtoResponse.setTickets(tickets);
        bookTicketDtoResponse.setPassengers(passengers);
        return new ResponseEntity<>(bookTicketDtoResponse, HttpStatus.OK);
    }


}
