package com.airline.service.impl;

import com.airline.converter.*;
import com.airline.dto.bookTicketsDto.request.BookTicketDtoRequest;
import com.airline.dto.bookTicketsDto.response.BookTicketDtoResponse;
import com.airline.dto.flightDto.request.FlightDtoDetail;
import com.airline.dto.searchTiketDto.response.SearchFlightDtoResponse;
import com.airline.dto.seatDto.request.SeatDtoDetail;
import com.airline.dto.userDto.request.UserDtoRequestDetail;
import com.airline.entity.*;
import com.airline.repository.*;
import com.airline.service.BookTicketService;
import com.airline.service.PassengerService;
//import com.airline.service.SeatService;
import com.airline.service.TicketService;
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
    @Autowired
    TicketService ticketService;
    @Override
    public Long save(BookTicketDtoRequest bookTicketDtoRequest,Long userId) {
        User user = userRepository.getUserById(userId);
        Flight flight = flightRepository.findByFlightNumber(bookTicketDtoRequest.getFlightNumber());
        OrderTicket orderTicket = bookTicketConverter.dtoToEntity(bookTicketDtoRequest);
        orderTicket.setExpireDate(Date.valueOf(LocalDate.now().plusDays(1)));
        orderTicket.setIs_status(false);
        orderTicket.setFlight(flight);
        orderTicket.setUser(user);
       bookTicketRepository.save(orderTicket);
       List<Passenger> passengers = passengerConverter.dtosToEntities(bookTicketDtoRequest.getPassengers());
       List<SeatDtoDetail> seatsDtoDetails = bookTicketDtoRequest.getSeatDtoDetails();
       //Get flight
        int quantityFirst = flight.getQuantityFirst();
        int quantitySecond = flight.getQuantitySecond();
        //Create List ticket
        List<Ticket> tickets = new ArrayList<>();
        //Save passenger
        for (Passenger passenger: passengers) {
            passenger.setUser(user);
            passenger.setOrders(orderTicket);
            passengerRepository.save(passenger);
        }
        //Update Flight and Seat
        for (SeatDtoDetail seatDetail: seatsDtoDetails
        ) {
            if (seatDetail.getSeatClass().equals("A")){
                Long seatId;
                do{
                    int seatNumberA = (int) (Math.random() * 5) + 1;
                    String seatR = "A" + seatNumberA;
                    seatId = seatRepository.findByFlightAndSeatNumber(flight.getId(),seatR);
                } while (seatId==null);
                Optional<Seat> seat = seatRepository.findById(seatId);
                seat.get().setSeatStatus(false);
                seat.get().setOrders(orderTicket);
                seatRepository.save(seat.get());
                //Update flight
                flight.setQuantityFirst(quantityFirst-1);
                flightRepository.save(flight);
                //Create Ticket
                Ticket ticket = ticketService.generateTicket(Date.valueOf(LocalDate.now()),
                        flight.getFlightNumber() + seat.get().getSeatNumber(),
                        2000L,
                        true,
                        flight,
                        orderTicket,
                        user
                        );
                tickets.add(ticket);
                ticketRepository.save(ticket);
            }else {
                int seatNumberB = (int) (Math.random() * 10) + 1;
                String seatR = "B" + seatNumberB;
                Long seatId = seatRepository.findByFlightAndSeatNumber(flight.getId(),seatR);
                Optional<Seat> seat = seatRepository.findById(seatId);
                seat.get().setSeatStatus(false);
                seat.get().setOrders(orderTicket);
                seatRepository.save(seat.get());
                //Update flight
                flight.setQuantitySecond((quantitySecond-1));
                flightRepository.save(flight);
                //Create Ticket
                Ticket ticket = ticketService.generateTicket(Date.valueOf(LocalDate.now()),
                        flight.getFlightNumber() + seat.get().getSeatNumber(),
                        1000L,
                        true,
                        flight,
                        orderTicket,
                        user
                );
                tickets.add(ticket);
                ticketRepository.save(ticket);
            }
        }
        //Save Order
        double price = 0;
        for (Ticket ticket: tickets
        ) {
            for (Passenger passenger: passengers
                 ) {
                if (passenger.getIsLuggage()){
                    price += 20;
                }
            }
            price += ticket.getTicketPrice();
        }
        orderTicket.setTotalPrice(price);
        bookTicketRepository.save(orderTicket);
        return orderTicket.getId();
    }

    @Override
    public BookTicketDtoResponse getOrderTicket(Long orderTicketId) {
        OrderTicket oderRes = bookTicketRepository.findById(orderTicketId).get();
        List<Ticket> tickets = ticketRepository.getTicketByOrders(oderRes);
        System.out.println(tickets.size());
        List<Passenger> passengers = passengerRepository.findAllByOrders(oderRes);
        System.out.println(passengers.size());
        BookTicketDtoResponse ticketDtoResponse = bookTicketConverter.entityToDto(oderRes);
        return ticketDtoResponse;
    }

    @Override
    public OrderTicket findById(Long orderId) {
        return bookTicketRepository.findById(orderId).get();
    }


}
