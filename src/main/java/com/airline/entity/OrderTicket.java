package com.airline.entity;

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
@Table(name = "order_ticket")
public class OrderTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;
    @OneToMany(mappedBy = "orders",fetch = FetchType.LAZY)
    private List<Passenger> passengers = new ArrayList<>();
    @OneToMany(mappedBy = "orders",fetch = FetchType.LAZY)
    private List<Luggage> luggages = new ArrayList<>();
    @OneToMany(mappedBy = "orders",fetch = FetchType.LAZY)
    private List<Ticket> tickets = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "is_status")
    private Boolean is_status;
    @Column(name = "expire_date")
    private Date expireDate;

}
