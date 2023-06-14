package com.airline.converter;

import com.airline.dto.passengerDto.request.PassengerDtoRequest;
import com.airline.dto.userDto.request.UserDtoCreateRequest;
import com.airline.entity.Passenger;
import com.airline.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PassengerConverter {
    public Passenger dtoToEntity(PassengerDtoRequest passengerDtoRequest){
        Passenger passenger = new Passenger();
//        System.out.println(passengerDtoRequest.getFirstName());
        BeanUtils.copyProperties(passengerDtoRequest, passenger);
//        System.out.println(passenger.getFirstName());
        return passenger;
    }
}
