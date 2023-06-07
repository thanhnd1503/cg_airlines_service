package com.airline.service;

import com.airline.dto.searchTiketDto.request.SearchTicketDtoRequest;
import com.airline.dto.searchTiketDto.response.SearchTicketDtoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface SearchTicketService {
    Page<SearchTicketDtoResponse> getSearchTicketDtoResponses(SearchTicketDtoRequest searchTicketDtoRequest, Pageable pageable);
}
