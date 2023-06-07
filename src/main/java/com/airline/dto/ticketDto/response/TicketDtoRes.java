package com.airline.dto.ticketDto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDtoRes {
    private long id;
    private String ticketNumber;
    private String flightNumber;
    private String departure;
    private String destination;
    private Date departureDate;
    private String departureTime;
    private String ticketClass;
    private Long ticketPrice;
    private Date bookingDate;
}
