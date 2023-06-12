package com.airline.service.impl;

import com.airline.converter.SearchTicketConverter;
import com.airline.dto.searchTiketDto.request.SearchTicketDtoRequest;
import com.airline.dto.searchTiketDto.response.SearchTicketDtoResponse;
import com.airline.entity.Ticket;
import com.airline.repository.SearchTicketRepository;
import com.airline.service.SearchTicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SearchTicketServiceImpl implements SearchTicketService {
    @Autowired
    SearchTicketConverter ticketConverter;
    @Autowired
    SearchTicketRepository repository;
    @Override
    public Page<SearchTicketDtoResponse> getSearchTicketDtoResponses(SearchTicketDtoRequest searchTicketDtoRequest, Pageable pageable) {
        Page<Ticket> tickets = repository.searchAllByAl(searchTicketDtoRequest.getDeparture(),
                searchTicketDtoRequest.getDestination(),
                searchTicketDtoRequest.getDepartureDate(),
                searchTicketDtoRequest.getTicketClass(),pageable);
        Page<SearchTicketDtoResponse> searchTicketDtoResponses = ticketConverter.entititesToDtos(tickets,pageable);
        return searchTicketDtoResponses;
    }

    @Override
    public Pageable createPageable(int page, int size, String[] sort) {
        Sort.Direction direction = Sort.Direction.ASC;
        String sortField = "ticketPrice";

        if (sort.length >= 2) {
            sortField = sort[0];
            if ("desc".equalsIgnoreCase(sort[1])) {
                direction = Sort.Direction.DESC;
            }
        }

        return PageRequest.of(page, size, direction, sortField);
    }
}
