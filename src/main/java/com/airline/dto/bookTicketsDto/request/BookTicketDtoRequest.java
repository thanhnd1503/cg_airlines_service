package com.airline.dto.bookTicketsDto.request;

import com.airline.entity.Luggage;
import com.airline.entity.Passenger;
import com.airline.entity.Ticket;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BookTicketDtoRequest {
    @NotEmpty
    List<Ticket> tickets;
    @NotEmpty
    List<Luggage> luggages;
    @NotEmpty
    List<Passenger> passengers;
    @NotNull
    private Double totalPrice;
    private Boolean is_status= true;
    private Date expireDate;
}
