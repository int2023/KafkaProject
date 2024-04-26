package com.example.demo.kafka;

import com.example.demo.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class KafkaProducer {

    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;

    public void sendMessage(Order order) {
        try {
            String jsonValue = objectMapper.writeValueAsString(order);
            kafkaTemplate.send("metrics-topic", jsonValue);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

}
