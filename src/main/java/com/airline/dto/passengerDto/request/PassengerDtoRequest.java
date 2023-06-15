package com.airline.dto.passengerDto.request;

import com.airline.dto.userDto.request.UserDtoRequestDetail;
import com.airline.entity.OrderTicket;
import com.airline.entity.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDtoRequest {
   @NotEmpty
   List<PassengerDtoDetail> passengerDtoDetails;
   @NotNull
   UserDtoRequestDetail userDtoRequestDetail;
}
