package com.airline.dto.passengerDto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDtoDetail {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Boolean isLuggage;
    @NotNull
    private Boolean gender;

}
