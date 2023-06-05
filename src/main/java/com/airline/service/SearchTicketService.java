package com.airline.service;

import com.airline.dto.tiketDto.request.SearchTicketDtoRequest;
import com.airline.dto.tiketDto.response.SearchTicketDtoResponse;


import java.sql.Date;
import java.util.List;


public interface SearchTicketService {
    List<SearchTicketDtoResponse> getSearchTicketDtoResponses(SearchTicketDtoRequest searchTicketDtoRequest);
}
