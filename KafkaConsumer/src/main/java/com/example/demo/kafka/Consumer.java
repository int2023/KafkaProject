package com.example.demo.kafka;

import com.example.demo.model.Order;
import com.example.demo.repository.MetricsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Consumer {
    private MetricsRepository metricsRepository;
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "metrics-topic",groupId = "1")
    public void listener(String text) {
        try {
            Order order = objectMapper.readValue(text, Order.class);
            System.out.println("Received: " + order);
            metricsRepository.save(order);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
