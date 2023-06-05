package com.airline.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Customer;

    private String From;

    private String Origin;

    private String Destination;

    private Double price;

    private String Seat;

    private String Date;

    private String Class;

    private String FlightId;


}
