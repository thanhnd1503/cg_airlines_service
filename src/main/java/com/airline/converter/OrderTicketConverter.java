package com.airline.converter;

import com.airline.dto.bookTicketsDto.request.BookTicketDtoRequest;
import com.airline.dto.bookTicketsDto.response.BookTicketDtoResponse;
import com.airline.dto.userDto.request.UserDtoCreateRequest;
import com.airline.entity.OrderTicket;
import com.airline.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrderTicketConverter {
    public OrderTicket dtoToEntity(BookTicketDtoRequest bookTicketDtoRequest){
        OrderTicket orderTicket = new OrderTicket();
        BeanUtils.copyProperties(bookTicketDtoRequest, orderTicket);
        return orderTicket;
    }
    public BookTicketDtoResponse entityToDto(OrderTicket orderTicket){
        BookTicketDtoResponse bookTicketDtoResponse = new BookTicketDtoResponse();
        BeanUtils.copyProperties(orderTicket,bookTicketDtoResponse);
        return bookTicketDtoResponse;
    }
}
