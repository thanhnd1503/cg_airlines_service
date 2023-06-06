package com.airline.service;

import com.airline.dto.tiketDto.request.SearchTicketDtoRequest;
import com.airline.dto.tiketDto.response.SearchTicketDtoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.sql.Date;
import java.util.List;


public interface SearchTicketService {
    Page<SearchTicketDtoResponse> getSearchTicketDtoResponses(SearchTicketDtoRequest searchTicketDtoRequest, Pageable pageable);
}
