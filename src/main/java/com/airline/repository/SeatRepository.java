package com.airline.repository;

import com.airline.entity.Flight;
import com.airline.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat,Long> {
    @Query(
            "SELECT s FROM Seat s WHERE s.seatStatus = true and s.flight = :#{#flight} and s.seatNumber = :seatNumber")
    Seat findFlightAndSeatClass(@Param("flight") Flight flight, @Param("seatNumber") String seatNumber);
}
