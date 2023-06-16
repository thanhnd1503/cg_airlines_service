package com.airline.converter;

import com.airline.dto.passengerDto.request.PassengerDtoDetail;
import com.airline.dto.passengerDto.request.PassengerDtoRequest;
import com.airline.dto.userDto.request.UserDtoCreateRequest;
import com.airline.dto.userRoleDto.response.UserRoleDtoResponse;
import com.airline.entity.Passenger;
import com.airline.entity.User;
import com.airline.entity.UserRole;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PassengerConverter {
    public Passenger dtoToEntity(PassengerDtoDetail passengerDtoDetail){
        Passenger passenger = new Passenger();
        BeanUtils.copyProperties(passengerDtoDetail, passenger);
        return passenger;
    }
    public List<Passenger> dtosToEntities(List<PassengerDtoDetail> passengerDtoDetails){
        List<Passenger> passengers = new ArrayList<>();
        if(!passengerDtoDetails.isEmpty()) {
            for(PassengerDtoDetail element : passengerDtoDetails){
                Passenger passenger = dtoToEntity(element);
                passengers.add(passenger);
            }
            return passengers;
        }
        return null;
    }
}
