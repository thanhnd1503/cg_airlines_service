package com.airline.converter;

import com.airline.dto.searchTiketDto.response.SearchFlightDtoResponse;
import com.airline.entity.Flight;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SearchFlightConverter {
    public SearchFlightDtoResponse entityToDto(Flight flight){
        SearchFlightDtoResponse flightDtoResponse = new SearchFlightDtoResponse();
        BeanUtils.copyProperties(flight, flightDtoResponse);

        return flightDtoResponse;
    }
    public Flight dtoToEntity(SearchFlightDtoResponse searchFlightDtoResponse){
        Flight flight = new Flight();
        BeanUtils.copyProperties(searchFlightDtoResponse, flight);

        return flight;
    }
    public Page<SearchFlightDtoResponse> entititesToDtos(Page<Flight> flights, Pageable pageable){
        List<SearchFlightDtoResponse> searchFlightDtoRespons = new ArrayList<>();
        for(Flight element : flights){
            SearchFlightDtoResponse searchFlightDtoResponse = entityToDto(element);
            searchFlightDtoRespons.add(searchFlightDtoResponse);
        }
        return PageableExecutionUtils.getPage(searchFlightDtoRespons, pageable, flights::getTotalElements);    }
}
