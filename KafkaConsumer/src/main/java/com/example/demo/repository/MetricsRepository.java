package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MetricsRepository extends JpaRepository<Order,Long> {

    List<Order> findByOrderingDateBetween(LocalDate startDate, LocalDate endDate);

}
