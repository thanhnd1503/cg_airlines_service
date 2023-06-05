package com.airline.converter;

import com.airline.dto.tiketDto.response.SearchTicketDtoResponse;
import com.airline.dto.userDto.response.UserDtoResponse;
import com.airline.entity.Ticket;
import com.airline.entity.User;
import org.springframework.beans.BeanUtils;
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
    public List<SearchTicketDtoResponse> entititesToDtos(List<Ticket> tickets){
        List<SearchTicketDtoResponse> searchTicketDtoResponses = new ArrayList<>();
        for(Ticket element : tickets){
            SearchTicketDtoResponse searchTicketDtoResponse = entityToDto(element);
            searchTicketDtoResponses.add(searchTicketDtoResponse);
        }
        return searchTicketDtoResponses;
    }
}
