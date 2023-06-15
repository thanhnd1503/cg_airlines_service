//package com.airline.service.impl;
//
//import com.airline.converter.OrderTicketConverter;
//import com.airline.dto.bookTicketsDto.request.BookTicketDtoRequest;
//import com.airline.dto.bookTicketsDto.response.BookTicketDtoResponse;
//import com.airline.entity.OrderTicket;
//import com.airline.entity.Passenger;
//import com.airline.entity.Ticket;
//import com.airline.repository.BookTicketRepository;
//import com.airline.repository.PassengerRepository;
//import com.airline.repository.TicketRepository;
//import com.airline.service.BookTicketService;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class BookTicketServiceImpl implements BookTicketService {
//   @Autowired
//   BookTicketRepository bookTicketRepository;
//
//   @Autowired
//    PassengerRepository passengerRepository;
//   @Autowired
//    TicketRepository ticketRepository;
//   @Autowired
//    OrderTicketConverter oderTicketConverter;
//    @Override
//    public void save(BookTicketDtoRequest bookTicketDtoRequest) {
//        OrderTicket orderTicket = oderTicketConverter.dtoToEntity(bookTicketDtoRequest);
//         bookTicketRepository.save(orderTicket);
//
//        List<Passenger> passengers = bookTicketDtoRequest.getPassengers();
//        for (Passenger passenger:passengers
//             ) {
//            passenger.setOrders(orderTicket);
//            passengerRepository.save(passenger);
//        }
//
//        List<Ticket> ticketFromBook = bookTicketDtoRequest.getTickets();
//        List<Ticket> tickets = ticketRepository.findAll();
//        for (Ticket ticketB :ticketFromBook){
//            for (Ticket ticket: tickets){
//                if(ticketB.getTicketNumber().equals(ticket.getTicketNumber()) ){
//                    ticket.setTicketStatus(true);
//                    ticket.setOrders(orderTicket);
//                    ticketRepository.save(ticket);
//                }
//            }
//        }
//
//    }
//
//    @Override
//    public BookTicketDtoResponse getOrderTicket(BookTicketDtoRequest bookTicketDtoRequest) {
//        BookTicketDtoResponse bookTicketResponse = oderTicketConverter.entityToDto(bookTicketDtoRequest);
//        return bookTicketResponse;
//    }
//}
