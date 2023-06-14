package com.airline.dto.passengerDto.request;

import com.airline.entity.OrderTicket;
import com.airline.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDtoRequest {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Boolean isLuggage;
    @NotNull
    private String gender;

    private OrderTicket orders;

    private User user;
}
