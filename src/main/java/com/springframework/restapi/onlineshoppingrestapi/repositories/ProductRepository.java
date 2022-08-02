package com.springframework.restapi.onlineshoppingrestapi.repositories;

import com.springframework.restapi.onlineshoppingrestapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
