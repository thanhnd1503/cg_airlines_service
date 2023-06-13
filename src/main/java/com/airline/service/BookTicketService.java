package com.airline.service;

import com.airline.dto.bookTicketsDto.request.BookTicketDtoRequest;
import com.airline.dto.bookTicketsDto.response.BookTicketDtoResponse;

public interface BookTicketService {
    void save(BookTicketDtoRequest bookTicketDtoRequest);
    BookTicketDtoResponse getOrderTicket(BookTicketDtoRequest bookTicketDtoRequest);
}
