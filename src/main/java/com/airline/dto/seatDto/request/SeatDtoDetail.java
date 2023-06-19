package com.airline.dto.seatDto.request;

import com.airline.entity.Flight;
import com.airline.entity.OrderTicket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SeatDtoDetail {
//    private String seatNumber;
    private String seatClass;
//    private Boolean seatStatus;
//    private Flight flight;
//    private OrderTicket orders;
}
