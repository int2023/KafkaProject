package com.example.demo.controller;

import com.example.demo.kafka.KafkaProducer;
import com.example.demo.model.Order;
import com.example.demo.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class OrdersController {

    private OrdersService ordersService;


    @PostMapping("metrics")
    public ResponseEntity<Order> createOrder(@RequestBody Order orders) {
        Order savedOrder = ordersService.createOrder(orders);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
