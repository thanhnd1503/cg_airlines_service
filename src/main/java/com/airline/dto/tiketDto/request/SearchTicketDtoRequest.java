package com.airline.dto.tiketDto.request;

import com.airline.entity.Ticket;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchTicketDtoRequest {
    @NotNull
    private String departure;
    @NotNull
    private String destination;
    @NotNull
    private Date departureDate;
    @NotNull
    private String ticketClass;
    private List<Ticket> listOfTicket;
}
