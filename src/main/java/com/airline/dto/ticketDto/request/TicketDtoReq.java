package com.airline.dto.ticketDto.request;

import com.airline.entity.Flight;
import com.airline.entity.OrderTicket;
import com.airline.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketDtoReq {
    private String ticketNumber;

    private Flight flight;

    private Long ticketPrice;

    private Date bookingDate;

    private Boolean ticketStatus;

    private User user;

    private OrderTicket orders;
}
