package com.airline.dto.bookTicketsDto.response;

import com.airline.entity.Luggage;
import com.airline.entity.Passenger;
import com.airline.entity.Ticket;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookTicketDtoResponse {

    List<Ticket> tickets;
    List<Luggage> luggages;

    List<Passenger> passengers;
    @NotNull
    private Double totalPrice;
}
