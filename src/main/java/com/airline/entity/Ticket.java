package com.airline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @ManyToOne
    @JoinColumn(name = "flight_id",referencedColumnName = "id")
    @JsonBackReference
    private Flight flight;
    @Column(name = "ticket_price",nullable = false)
    private Long ticketPrice;
    @Column(name = "booking_date",nullable = false)
    private Date bookingDate;
    @Column(name = "ticket_status",nullable = false)
    private Boolean ticketStatus;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    @JsonBackReference
    private OrderTicket orders;

}
