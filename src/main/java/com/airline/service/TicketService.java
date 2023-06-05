package com.airline.service;

import com.airline.entity.Ticket;

import java.awt.print.Pageable;
import java.util.List;

public interface TicketService {
    List<Ticket> findALlTicketPage(String name, Pageable pageable);

}
