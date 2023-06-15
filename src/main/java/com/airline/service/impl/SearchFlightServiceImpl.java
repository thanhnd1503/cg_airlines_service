package com.airline.service.impl;

import com.airline.converter.SearchFlightConverter;
import com.airline.dto.searchTiketDto.request.SearchFlightDtoRequest;
import com.airline.dto.searchTiketDto.response.SearchFlightDtoResponse;
import com.airline.entity.Flight;
import com.airline.repository.SearchFlightRepository;
import com.airline.service.SearchFlightService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SearchFlightServiceImpl implements SearchFlightService {
    @Autowired
    SearchFlightConverter flightConverter;
    @Autowired
    SearchFlightRepository repository;
    @Override
    public Page<SearchFlightDtoResponse> getSearchFlightDtoResponses(SearchFlightDtoRequest searchFlightDtoRequest, Pageable pageable) {
        Page<Flight> flights = repository.searchAllByAl(searchFlightDtoRequest.getDeparture(),
                searchFlightDtoRequest.getDestination(),
                searchFlightDtoRequest.getDepartureDate(),pageable);
        Page<SearchFlightDtoResponse> searchFlightDtoResponses = flightConverter.entititesToDtos(flights,pageable);
        return searchFlightDtoResponses;
    }


}
