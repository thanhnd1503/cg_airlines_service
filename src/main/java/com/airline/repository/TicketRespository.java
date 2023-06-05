package com.airline.repository;

import com.airline.entity.Ticket;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface TicketRespository extends JpaRepository<Ticket, Long> {
    @Query(nativeQuery = true, value = "select * from ticket")
    List<Ticket> findAllTicketPage(@Param("") String name, Pageable pageable);
}
