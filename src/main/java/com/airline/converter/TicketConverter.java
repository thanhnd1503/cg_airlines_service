package com.airline.converter;

import com.airline.dto.ticketDto.request.TicketDtoReq;
import com.airline.dto.ticketDto.response.TicketDtoRes;
import com.airline.entity.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TicketConverter {
    public TicketDtoReq entityToDto(Ticket ticket){
        TicketDtoReq ticketDtoReq = new TicketDtoReq();
        BeanUtils.copyProperties(ticket, ticketDtoReq);
        return ticketDtoReq;
    }
}
