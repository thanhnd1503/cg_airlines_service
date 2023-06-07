package com.airline.repository;

import com.airline.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface SearchTicketRepository extends JpaRepository<Ticket, Long> {
    @Query( "SELECT t FROM Ticket t WHERE t.departure = :departure and t.destination = :destination and t.departureDate = :departureDate and t.ticketClass = :ticketClass and t.ticketStatus = false ")
    Page<Ticket> searchAllByAl(@Param("departure") String departure, @Param("destination") String destination, @Param("departureDate") Date departureDate, @Param("ticketClass") String ticketClass, Pageable pageable);
}
