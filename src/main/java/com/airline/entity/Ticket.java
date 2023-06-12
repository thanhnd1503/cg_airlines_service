package com.airline.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "ticket_number",nullable = false)
    private String ticketNumber;
    @Column(name = "flight_number",nullable = false)
    private String flightNumber;
    @Column(name = "departure",nullable = false)
    private String departure;
    @Column(name = "destination",nullable = false)
    private String destination;
    @Column(name = "departure_date",nullable = false)
    private Date departureDate;
    @Column(name = "departure_Time",nullable = false)
    private String departureTime;
    @Column(name = "ticket_class",nullable = false)
    private String ticketClass;
    @Column(name = "seat_number",nullable = false)
    private String seatNumber;
    @Column(name = "ticket_price",nullable = false)
    private Long ticketPrice;
    @Column(name = "ticket_status",nullable = false)
    private Boolean ticketStatus;
    @Column(name = "booking_date",nullable = false)
    private Date bookingDate;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private OrderTicket orders;

}
