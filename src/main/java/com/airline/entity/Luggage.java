package com.airline.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "luggage")
public class Luggage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "kilogam",nullable = false)
    private Long kilogam;
    @Column(name = "price",nullable = false)
    private Double price;
    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private OrderTicket orders;
    @ManyToOne
    @JoinColumn(name = "passenger_id",referencedColumnName = "id")
    private Passenger passenger;
}
