package com.airline.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number",nullable = false)
    private String seatNumber;

    @Column(name = "seat_class",nullable = false)
    private String seatClass;


    @Column(name = "seat_status",nullable = false)
    private Boolean seatStatus;

    @ManyToOne
    @JoinColumn(name = "flight_id",referencedColumnName = "id")
    @JsonBackReference
    private Flight flight;


}
