package com.airline.dto.flightDto.request;

import com.airline.entity.Ticket;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDtoDetail {

    private List<Ticket> tickets = new ArrayList<>();

    private String departure;

    private String flightNumber;

    private String destination;

    private Date departureDate;

    private String departureTime;

    private Integer quantityFirst;

    private Integer quantitySecond;
}
