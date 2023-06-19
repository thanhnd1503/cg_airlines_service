package com.airline.service.impl;

import com.airline.converter.TicketConverter;
import com.airline.dto.ticketDto.response.TicketDtoRes;
import com.airline.entity.Flight;
import com.airline.entity.OrderTicket;
import com.airline.entity.Ticket;
import com.airline.entity.User;
import com.airline.repository.BookTicketRepository;
import com.airline.repository.TicketRepository;
import com.airline.service.TicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    BookTicketRepository bookTicketRepository;
    @Autowired
    TicketConverter ticketConverter;
    @Override
    public TicketDtoRes getTicketDtoResByTicketNumber(String ticketNumber) {
        Ticket ticket = ticketRepository.getTicketByTicketNumber(ticketNumber);
//        TicketDtoRes res = ticketConverter.entityToDto(ticket);
        return null;
    }

    @Override
    public List<Ticket> getTicketByOrders(OrderTicket orderTicket) {
        return ticketRepository.getTicketByOrders(bookTicketRepository.findById(orderTicket.getId()).get());
    }

    @Override
    public Ticket generateTicket(Date bookingDate, String ticketNumber, Long ticketPrice, Boolean ticketStatus, Flight flight, OrderTicket orderTicket, User user) {
        return new Ticket(ticketNumber, flight, ticketPrice, bookingDate, ticketStatus, user, orderTicket);
    }
}
