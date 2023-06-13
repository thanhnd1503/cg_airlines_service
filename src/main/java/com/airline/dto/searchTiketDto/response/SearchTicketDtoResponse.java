package com.airline.dto.searchTiketDto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchTicketDtoResponse {
    private String ticketNumber;

    private String departure;

    private String destination;

    private String departureTime;

    private String ticketClass;

    private Long ticketPrice;
//    private Integer numberOfTickets;

}
