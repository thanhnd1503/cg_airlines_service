package com.airline.service;

import com.airline.dto.passengerDto.request.PassengerDtoRequest;
import com.airline.entity.OrderTicket;
import com.airline.entity.Passenger;

import java.util.List;

public interface PassengerService {
     Boolean save(PassengerDtoRequest passengerDtoRequest);

     List<Passenger> findAllByOrders (OrderTicket orderTicket);
}
