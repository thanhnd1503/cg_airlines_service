package com.airline.service.impl;

import com.airline.converter.TicketConverter;
import com.airline.dto.tiketDto.request.SearchTicketDtoRequest;
import com.airline.dto.tiketDto.response.SearchTicketDtoResponse;
import com.airline.entity.Ticket;
import com.airline.repository.TicketRepository;
import com.airline.service.SearchTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchTicketServiceImpl implements SearchTicketService {
    @Autowired
    TicketConverter ticketConverter;
    @Autowired
    TicketRepository repository;
    @Override
    public Page<SearchTicketDtoResponse> getSearchTicketDtoResponses(SearchTicketDtoRequest searchTicketDtoRequest, Pageable pageable) {
        Page<Ticket> tickets = repository.searchAllByAl(searchTicketDtoRequest.getDeparture(),
                searchTicketDtoRequest.getDestination(),
                searchTicketDtoRequest.getDepartureDate(),
                searchTicketDtoRequest.getTicketClass(),pageable);
        Page<SearchTicketDtoResponse> searchTicketDtoResponses = ticketConverter.entititesToDtos(tickets,pageable);
        return searchTicketDtoResponses;
    }
}
