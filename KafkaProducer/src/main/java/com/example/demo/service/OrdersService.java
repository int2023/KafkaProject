package com.example.demo.service;

import com.example.demo.kafka.KafkaProducer;
import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrdersService {
    private OrderRepository orderRepository;
    private KafkaProducer kafkaProducer;

    public Order createOrder(Order newOrder) {
        Order order = orderRepository.save(newOrder);
        kafkaProducer.sendMessage(order);
        return order;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getByID(Long id) {
        Optional<Order> byId = orderRepository.findById(id);
        return byId.orElse(null);
    }

    public void deleteByID(Long id) {
        orderRepository.deleteById(id);
    }

}
