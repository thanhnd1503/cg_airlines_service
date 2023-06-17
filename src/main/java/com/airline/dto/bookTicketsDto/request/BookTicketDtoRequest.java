package com.airline.dto.bookTicketsDto.request;

import com.airline.dto.flightDto.request.FlightDtoDetail;
import com.airline.dto.passengerDto.request.PassengerDtoDetail;
import com.airline.dto.searchTiketDto.request.SearchFlightDtoRequest;
import com.airline.dto.searchTiketDto.response.SearchFlightDtoResponse;
import com.airline.dto.seatDto.request.SeatDtoDetail;
import com.airline.dto.ticketDto.request.TicketDtoReq;
import com.airline.dto.userDto.request.UserDtoRequestDetail;
import com.airline.entity.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BookTicketDtoRequest {
//    @NotNull
    //private SearchFlightDtoResponse searchFlightDtoResponse;
    private String flightNumber;
//    @NotEmpty
    private List<PassengerDtoDetail> passengers = new ArrayList<>();
//    @NotEmpty
    private List<SeatDtoDetail> seatDtoDetails = new ArrayList<>();
}
