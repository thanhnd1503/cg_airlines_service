package com.airline.dto.tiketDto.response;

import com.airline.entity.Ticket;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchTicketDtoResponse {
    private String departure;

    private String destination;

    private String departureTime;

    private String ticketClass;

}
