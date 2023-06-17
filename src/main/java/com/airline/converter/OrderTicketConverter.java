package com.airline.converter;

import com.airline.dto.bookTicketsDto.request.BookTicketDtoRequest;
import com.airline.dto.bookTicketsDto.response.BookTicketDtoResponse;
import com.airline.dto.passengerDto.request.PassengerDtoDetail;
import com.airline.dto.userDto.request.UserDtoCreateRequest;
import com.airline.entity.*;
import com.airline.repository.FlightRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderTicketConverter {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerConverter passengerConverter;

    @Autowired
    private SeatConverter seatConverter;
    public OrderTicket dtoToEntity(BookTicketDtoRequest bookTicketDtoRequest){
        OrderTicket orderTicket = new OrderTicket();
        Flight flight = flightRepository.findByFlightNumber(bookTicketDtoRequest.getFlightNumber());
        List<PassengerDtoDetail> passengerDtos = bookTicketDtoRequest.getPassengers();
        List<Passenger> passengers =passengerConverter.dtosToEntities(passengerDtos);
        List<Seat> seats = seatConverter.dtosToEntities(bookTicketDtoRequest.getSeatDtoDetails());
        orderTicket.setFlight(flight);
        orderTicket.setPassengers(passengers);
        orderTicket.setSeats(seats);
        return orderTicket;
    }
    public BookTicketDtoResponse entityToDto(OrderTicket orderTicket){
        BookTicketDtoResponse bookTicketDtoResponse = new BookTicketDtoResponse();
        BeanUtils.copyProperties(orderTicket,bookTicketDtoResponse);
        return bookTicketDtoResponse;
    }
}
