package com.airline.service;

import com.airline.dto.bookTicketsDto.request.BookTicketDtoRequest;
import com.airline.dto.bookTicketsDto.response.BookTicketDtoResponse;
import com.airline.entity.Flight;
import com.airline.entity.OrderTicket;
import com.airline.entity.Ticket;
import com.airline.entity.User;

import java.sql.Date;

public interface BookTicketService {
    Long save(BookTicketDtoRequest bookTicketDtoRequest,Long userId);
    BookTicketDtoResponse getOrderTicket(Long orderTicketId);

}
