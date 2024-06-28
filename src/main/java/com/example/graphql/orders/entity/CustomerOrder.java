package com.example.graphql.orders.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// The CustomerOrder class is an entity in the database that represents an order. It includes fields such as orderId, orderDetail, and price, and establishes a many-to-one relationship with the User entity using JPA annotations for persistence management.

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    private String orderDetail;

    private Integer price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}

