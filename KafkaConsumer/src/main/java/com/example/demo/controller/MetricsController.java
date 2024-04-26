package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.MetricsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
public class MetricsController {
    private MetricsService metricsService;

    @GetMapping("metrics")
    public List<Order> getMetrics() {
        return metricsService.getAllOrders();
    }

    @GetMapping("metrics/{id}")
    public Order getMetricById(@PathVariable Long id) {
        return metricsService.getByID(id);
    }

    @GetMapping("metrics/between")
    public List<Order> getBetweenDates (@RequestParam LocalDate startDate,
                                        @RequestParam LocalDate endDate) {
        return metricsService.getOrdersBetweenDates(startDate,endDate);
    }



}
