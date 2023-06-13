package com.airline.service;


import com.airline.dto.ticketDto.response.TicketDtoRes;
import com.airline.entity.Ticket;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface TicketService {

    TicketDtoRes getTicketDtoResByTicketNumber(String ticketNumber);
}
