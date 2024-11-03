package com.example.order_service.service;


import com.example.order_service.client.UserClient;
import com.example.order_service.model.Order;
import com.example.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    private final UserClient userClient;

    public OrderService(OrderRepository orderRepository, UserClient userClient) {
        this.orderRepository = orderRepository;
        this.userClient = userClient;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
        // Kullanıcı bilgilerini almak için UserClient kullanıyoruz
        String userName = userClient.getUserById(order.getUserId()).getName();
        order.setProduct("Order for user: " + userName);
        return orderRepository.save(order);
    }
}
