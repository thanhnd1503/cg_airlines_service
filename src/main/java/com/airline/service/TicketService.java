package com.airline.service;

import com.airline.dto.ticketDto.response.TicketDtoRes;

import java.util.Optional;

public interface TicketService {
    TicketDtoRes getTicketDtoResByTicketNumber(String ticketNumber);
}
