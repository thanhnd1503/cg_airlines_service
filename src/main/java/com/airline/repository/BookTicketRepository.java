package com.airline.repository;

import com.airline.entity.OrderTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTicketRepository extends JpaRepository<OrderTicket,Long> {
}
