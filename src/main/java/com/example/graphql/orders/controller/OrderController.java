package com.example.graphql.orders.controller;

import com.example.graphql.orders.entity.CustomerOrder;
import com.example.graphql.orders.entity.User;
import com.example.graphql.orders.service.OrderService;
import com.example.graphql.orders.service.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    private final UserService userService;
    private final OrderService orderService;

    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    // create order
    @MutationMapping
    public CustomerOrder createOrder(@Argument Long userId,
                                     @Argument String orderDescription,
                                     @Argument Integer price) {

        Optional<User> user = Optional.ofNullable(userService.getUserById(userId));

        CustomerOrder order = new CustomerOrder();
        order.setOrderDetail(orderDescription);
        order.setPrice(price);
        order.setUser(user.get());

        return order;
    }

    // get order by id
    @QueryMapping
    public CustomerOrder getOrderById(@Argument Long orderId) {
        return orderService.getOrderById(orderId);
    }

    // get all orders
    @QueryMapping
    public List<CustomerOrder> getAllOrders() {
        return orderService.getOrders();
    }

    // delete order
    @MutationMapping
    public void deleteOrder(@Argument Long orderId) {
        orderService.deleteOrder(orderId);
    }






}
