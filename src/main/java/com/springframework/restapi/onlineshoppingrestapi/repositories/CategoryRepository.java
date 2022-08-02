package com.springframework.restapi.onlineshoppingrestapi.repositories;

import com.springframework.restapi.onlineshoppingrestapi.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
