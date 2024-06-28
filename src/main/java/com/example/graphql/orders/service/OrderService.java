package com.example.graphql.orders.service;

import com.example.graphql.orders.entity.CustomerOrder;
import com.example.graphql.orders.repo.CustomerOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private  final CustomerOrderRepo orderRepo;

    @Autowired
    public OrderService(CustomerOrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<CustomerOrder> getOrders() {
        return orderRepo.findAll();
    }

    public CustomerOrder saveOrder(CustomerOrder order) {
        return orderRepo.save(order);
    }

    public void deleteOrder(Long orderId) {
        if (orderRepo.existsById(orderId)) {
            orderRepo.deleteById(orderId);
        } else {
            throw new IllegalArgumentException("Order not found");
        }
    }

    public CustomerOrder updateOrder(CustomerOrder order) {
        if (orderRepo.existsById(order.getOrderId())) {
            return orderRepo.save(order);
        } else {
            throw  new IllegalArgumentException("Order not found");
        }
    }

    public CustomerOrder getOrderById(Long orderId) {
        return orderRepo.findById(orderId).orElse(null);
    }


}
