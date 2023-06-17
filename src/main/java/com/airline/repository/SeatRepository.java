package com.airline.repository;

import com.airline.entity.Flight;
import com.airline.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {
    @Query("SELECT s.id FROM Seat s JOIN s.flight f WHERE s.seatStatus = true AND f.id = :flightId AND s.seatNumber = :seatNumber")
    Long findByFlightAndSeatNumber(@Param("flightId") Long flightId, @Param("seatNumber") String seatNumber);}


