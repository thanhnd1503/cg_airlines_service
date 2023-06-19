package com.airline.dto.bookTicketsDto.response;

import com.airline.dto.passengerDto.request.PassengerDtoDetail;
import com.airline.dto.passengerDto.request.PassengerDtoRequest;
import com.airline.dto.ticketDto.response.TicketDtoRes;
import com.airline.entity.Passenger;
import com.airline.entity.Ticket;
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

    List<TicketDtoRes> tickets;

    List<PassengerDtoDetail> passengers;
    @NotNull
    private Double totalPrice;
}
