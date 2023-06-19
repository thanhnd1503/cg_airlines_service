package com.airline.service;


import com.airline.dto.ticketDto.response.TicketDtoRes;
import com.airline.entity.Flight;
import com.airline.entity.OrderTicket;
import com.airline.entity.Ticket;
import com.airline.entity.User;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface TicketService {

    TicketDtoRes getTicketDtoResByTicketNumber(String ticketNumber);
    List<Ticket> getTicketByOrders(OrderTicket orderTicket);
    Ticket generateTicket(Date bookingDate, String ticketNumber, Long ticketPrice, Boolean ticketStatus, Flight flight, OrderTicket orderTicket, User user);
}
