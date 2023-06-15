package com.airline.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "flight",fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Ticket> tickets = new ArrayList<>();
    @Column(name = "departure",nullable = false)
    private String departure;
    @Column(name = "flight_number",nullable = false)
    private String flightNumber;
    @Column(name = "destination",nullable = false)
    private String destination;
    @Column(name = "departure_date",nullable = false)
    private Date departureDate;
    @Column(name = "departure_Time",nullable = false)
    private String departureTime;
    @Column(name = "quantity_first",nullable = true)
    private Integer quantityFirst;
    @Column(name = "quantity_second",nullable = true)
    private Integer quantitySecond;
}
