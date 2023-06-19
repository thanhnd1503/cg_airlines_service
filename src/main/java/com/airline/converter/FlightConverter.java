package com.airline.converter;

import com.airline.dto.flightDto.request.FlightDtoDetail;
import com.airline.entity.Flight;
import org.springframework.beans.BeanUtils;

public class FlightConverter {
    public Flight dtoToEntity(FlightDtoDetail flightDtoDetail){
        Flight flight = new Flight();
        BeanUtils.copyProperties(flightDtoDetail, flight);
        return flight;
    }
    public FlightDtoDetail entityToDto(Flight flight){
        FlightDtoDetail flightDtoDetail = new FlightDtoDetail();
        BeanUtils.copyProperties(flight,flightDtoDetail);
        return flightDtoDetail;
    }
}
