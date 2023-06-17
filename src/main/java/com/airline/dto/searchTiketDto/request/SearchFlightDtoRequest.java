package com.airline.dto.searchTiketDto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchFlightDtoRequest {
    @NotNull
    private String departure;
    @NotNull
    private String destination;
    @NotNull
    private Date departureDate;


}
