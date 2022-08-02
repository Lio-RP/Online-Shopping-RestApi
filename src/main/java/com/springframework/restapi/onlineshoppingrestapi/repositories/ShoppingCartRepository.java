package com.springframework.restapi.onlineshoppingrestapi.repositories;

import com.springframework.restapi.onlineshoppingrestapi.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
}
