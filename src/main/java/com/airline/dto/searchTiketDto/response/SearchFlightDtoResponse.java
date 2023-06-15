package com.airline.dto.searchTiketDto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SearchFlightDtoResponse {
    private String departure;

    private String destination;

    private String departureTime;
    private Integer quantityFirst;
    private Integer quantitySecond;
    private String flightNumber;
}
