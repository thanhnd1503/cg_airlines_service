package com.airline.service;

import com.airline.dto.searchTiketDto.request.SearchFlightDtoRequest;
import com.airline.dto.searchTiketDto.response.SearchFlightDtoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SearchFlightService {
    Page<SearchFlightDtoResponse> getSearchFlightDtoResponses(SearchFlightDtoRequest searchFlightDtoRequest, Pageable pageable);
}
