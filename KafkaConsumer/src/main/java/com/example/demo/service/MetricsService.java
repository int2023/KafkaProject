package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.MetricsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class MetricsService {

    private MetricsRepository metricsRepository;

    public void saveOrder(Order order) {
        metricsRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return metricsRepository.findAll();
    }

    public Order getByID (Long id) {
        return metricsRepository.findById(id).orElse(null);
    }

    public List<Order> getOrdersBetweenDates(LocalDate startDate, LocalDate endDate) {
        return metricsRepository.findAll();
    }


}
