package com.airline.service.impl;

import com.airline.entity.Ticket;
import com.airline.repository.TicketRespository;
import com.airline.service.TicketService;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class TicketImpl implements TicketService {
    private final TicketRespository ticketRespository;

    public TicketImpl(TicketRespository ticketRespository) {
        this.ticketRespository = ticketRespository;
    }

    @Override
    public List<Ticket> findALlTicketPage(String name, Pageable pageable) {
        return ticketRespository.findAllTicketPage(name, pageable);
    }

}
