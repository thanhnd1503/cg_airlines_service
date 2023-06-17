package com.airline.repository;

import com.airline.entity.Flight;
import com.airline.entity.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface SearchFlightRepository extends JpaRepository<Ticket, Long> {
    @Query( "SELECT f FROM Flight f WHERE f.departure = :departure and f.destination = :destination and f.departureDate = :departureDate ")
    Page<Flight> searchAllByAl(@Param("departure") String departure, @Param("destination") String destination, @Param("departureDate") Date departureDate, Pageable pageable);
}
