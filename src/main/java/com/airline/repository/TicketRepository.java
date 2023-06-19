package com.airline.repository;

import com.airline.entity.OrderTicket;
import com.airline.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Ticket getTicketByTicketNumber(String ticketNumber);

    List<Ticket> getTicketByOrders(OrderTicket orderTicket);
}
