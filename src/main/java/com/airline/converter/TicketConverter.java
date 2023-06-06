package com.airline.converter;

import com.airline.dto.tiketDto.response.SearchTicketDtoResponse;
import com.airline.entity.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TicketConverter {
    public SearchTicketDtoResponse entityToDto(Ticket ticket){
        SearchTicketDtoResponse ticketDtoResponse = new SearchTicketDtoResponse();
        BeanUtils.copyProperties(ticket, ticketDtoResponse);
//        userDtoResponse.setUserRoleDtos(userRoleConverter.entitiesToDtos(user.getUserRoles()));
        return ticketDtoResponse;
    }
    public Page<SearchTicketDtoResponse> entititesToDtos(Page<Ticket> tickets, Pageable pageable){
        List<SearchTicketDtoResponse> searchTicketDtoResponses = new ArrayList<>();
        for(Ticket element : tickets){
            SearchTicketDtoResponse searchTicketDtoResponse = entityToDto(element);
            searchTicketDtoResponses.add(searchTicketDtoResponse);
        }
        return PageableExecutionUtils.getPage(searchTicketDtoResponses, pageable, tickets::getTotalElements);    }
}
