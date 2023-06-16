package com.airline.service.impl;

import com.airline.converter.*;
import com.airline.dto.bookTicketsDto.request.BookTicketDtoRequest;
import com.airline.dto.bookTicketsDto.response.BookTicketDtoResponse;
import com.airline.dto.seatDto.request.SeatDtoDetail;
import com.airline.dto.userDto.request.UserDtoRequestDetail;
import com.airline.entity.*;
import com.airline.repository.*;
import com.airline.service.BookTicketService;
import com.airline.service.PassengerService;
//import com.airline.service.SeatService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookTicketServiceImpl implements BookTicketService {
    @Autowired
    BookTicketRepository bookTicketRepository;
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    SearchFlightConverter searchFlightConverter;
    @Autowired
    SeatRepository seatRepository;
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    SeatConverter seatConverter;
    @Autowired
    PassengerService passengerService;
    @Autowired
    PassengerConverter passengerConverter;
    @Autowired
    OrderTicketConverter bookTicketConverter;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    TicketRepository ticketRepository;
    @Override
    public void save(BookTicketDtoRequest bookTicketDtoRequest) {
        //Get user information
        UserDtoRequestDetail userDtoRequestDetail = bookTicketDtoRequest.getUserDtoRequestDetail();
        String email = userDtoRequestDetail.getEmail();
        User user = userRepository.findUserByEmail(email);
        //Convert
        OrderTicket orderTicket = bookTicketConverter.dtoToEntity(bookTicketDtoRequest);
        List<Passenger> passengers = passengerConverter.dtosToEntities(bookTicketDtoRequest.getPassengers());
        List<SeatDtoDetail> seatsDtoDetails = bookTicketDtoRequest.getSeatDtoDetails();
        //Get Flight from request
        String flightNumber = bookTicketDtoRequest.getSearchFlightDtoResponse().getFlightNumber();
        Flight flightApterOrder = flightRepository.findByFlightNumber(flightNumber);
        int quantityFirst = flightApterOrder.getQuantityFirst();
        int quantitySecond = flightApterOrder.getQuantitySecond();
        //Create List ticket
        List<Ticket> tickets = new ArrayList<>();
        //Save passenger
        for (Passenger passenger: passengers) {
            passenger.setUser(user);
            passengerRepository.save(passenger);
        }
        //Update Flight and Seat;
        for (SeatDtoDetail seatDetail: seatsDtoDetails
             ) {
            if (seatDetail.getSeatClass().equals("A")){
                int seatNumberA = (int) (Math.random() * 5) + 1;
                String seatR = "A" + seatNumberA;
                Seat seat = seatRepository.findFlightAndSeatClass(flightApterOrder,seatR);
                seat.setSeatStatus(false);
                seatRepository.save(seat);
                //Update flight
                flightApterOrder.setQuantityFirst(quantityFirst-1);
                flightRepository.save(flightApterOrder);
                //Create Ticket
                Ticket ticket = new Ticket();
                ticket.setBookingDate(Date.valueOf(LocalDate.now()));
                ticket.setTicketNumber(flightApterOrder.getFlightNumber() + ticket.getId());
                ticket.setTicketPrice(2000L);
                ticket.setTicketStatus(true);
                ticket.setFlight(flightApterOrder);
                ticket.setOrders(orderTicket);
                ticket.setUser(user);
                tickets.add(ticket);

                ticketRepository.save(ticket);
            }else {
                int seatNumberB = (int) (Math.random() * 10) + 1;
                String seatR = "B" + seatNumberB;
                Seat seat = seatRepository.findFlightAndSeatClass(flightApterOrder,seatR);
                seat.setSeatStatus(false);
                seatRepository.save(seat);
                flightApterOrder.setQuantityFirst(quantitySecond-1);
                flightRepository.save(flightApterOrder);
                //Create Ticket
                Ticket ticket = new Ticket();
                ticket.setBookingDate(Date.valueOf(LocalDate.now()));
                ticket.setTicketNumber(flightApterOrder.getFlightNumber() + ticket.getId());
                ticket.setTicketPrice(1000L);
                ticket.setTicketStatus(true);
                ticket.setFlight(flightApterOrder);
                ticket.setOrders(orderTicket);
                ticket.setUser(user);
                tickets.add(ticket);
                ticketRepository.save(ticket);
            }
        }

//        Save Order
        orderTicket.setExpireDate(Date.valueOf(LocalDate.now().plusDays(1)));
        orderTicket.setIs_status(false);
        double price =0;
        for (Ticket ticket: tickets
             ) {
            price += ticket.getTicketPrice();
        }
        orderTicket.setTotalPrice(price);
        orderTicket.setFlight(flightApterOrder);
        orderTicket.setUser(user);
    }

    @Override
    public BookTicketDtoResponse getOrderTicket(BookTicketDtoRequest bookTicketDtoRequest) {
        OrderTicket orderTicket = bookTicketConverter.dtoToEntity(bookTicketDtoRequest);
        BookTicketDtoResponse ticketDtoResponse = bookTicketConverter.entityToDto(orderTicket);
        return ticketDtoResponse;
    }


}
