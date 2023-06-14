package com.airline.service.impl;

import com.airline.converter.PassengerConverter;
import com.airline.dto.passengerDto.request.PassengerDtoRequest;
import com.airline.entity.Passenger;
import com.airline.repository.PassengerRepository;
import com.airline.service.PassengerService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {
    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    PassengerConverter passengerConverter;
    @Override
    public void save(PassengerDtoRequest passengerDtoRequest) {
        Passenger passenger = passengerConverter.dtoToEntity(passengerDtoRequest);
        passengerRepository.save(passenger);
    }
}
