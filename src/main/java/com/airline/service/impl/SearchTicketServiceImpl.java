package com.airline.service.impl;

import com.airline.converter.TicketConverter;
import com.airline.dto.tiketDto.request.SearchTicketDtoRequest;
import com.airline.dto.tiketDto.response.SearchTicketDtoResponse;
import com.airline.entity.Ticket;
import com.airline.repository.TicketRepository;
import com.airline.service.SearchTicketService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<SearchTicketDtoResponse> getSearchTicketDtoResponses(SearchTicketDtoRequest searchTicketDtoRequest) {
        List<Ticket> tickets = repository.searchAllByAl(searchTicketDtoRequest.getDeparture(), searchTicketDtoRequest.getDestination(), searchTicketDtoRequest.getDepartureDate(), searchTicketDtoRequest.getTicketClass());
        List<SearchTicketDtoResponse> searchTicketDtoResponses = ticketConverter.entititesToDtos(tickets);
        return searchTicketDtoResponses;
    }
}
