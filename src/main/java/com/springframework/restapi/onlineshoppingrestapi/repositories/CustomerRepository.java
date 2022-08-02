package com.springframework.restapi.onlineshoppingrestapi.repositories;

import com.springframework.restapi.onlineshoppingrestapi.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
