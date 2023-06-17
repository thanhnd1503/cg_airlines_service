package com.airline.converter;

import com.airline.dto.passengerDto.request.PassengerDtoDetail;
import com.airline.dto.seatDto.request.SeatDtoDetail;
import com.airline.dto.ticketDto.request.TicketDtoReq;
import com.airline.entity.Passenger;
import com.airline.entity.Seat;
import com.airline.entity.Ticket;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SeatConverter {
    public SeatDtoDetail entityToDto(Seat seat){
        SeatDtoDetail seatDtoDetail = new SeatDtoDetail();
        BeanUtils.copyProperties(seat, seatDtoDetail);
        return seatDtoDetail;
    }
    public Seat dtoToEntity(SeatDtoDetail seatDtoDetail){
        Seat seat = new Seat();
        BeanUtils.copyProperties(seatDtoDetail, seat);
        return seat;
    }
    public List<Seat> dtosToEntities(List<SeatDtoDetail> seatDtoDetails){
        List<Seat> seats = new ArrayList<>();
        if(!seatDtoDetails.isEmpty()) {
            for(SeatDtoDetail element : seatDtoDetails){
                Seat seat = dtoToEntity(element);
                seats.add(seat);
            }
            return seats;
        }
        return null;
    }
}
