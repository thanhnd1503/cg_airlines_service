package com.airline.converter;

import com.airline.dto.ticketDto.response.TicketDtoRes;
import com.airline.entity.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TicketConverter {
    public TicketDtoRes entityToDto(Ticket ticket){
        TicketDtoRes ticketDtoRes = new TicketDtoRes();
        BeanUtils.copyProperties(ticket, ticketDtoRes);
        return ticketDtoRes;
    }
}
