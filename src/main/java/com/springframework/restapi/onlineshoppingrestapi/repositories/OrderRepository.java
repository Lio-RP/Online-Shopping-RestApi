package com.springframework.restapi.onlineshoppingrestapi.repositories;

import com.springframework.restapi.onlineshoppingrestapi.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
