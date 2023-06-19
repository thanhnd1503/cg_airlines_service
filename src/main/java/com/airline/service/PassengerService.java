package com.airline.service;

import com.airline.dto.passengerDto.request.PassengerDtoRequest;

public interface PassengerService {
     Boolean save(PassengerDtoRequest passengerDtoRequest);
}
