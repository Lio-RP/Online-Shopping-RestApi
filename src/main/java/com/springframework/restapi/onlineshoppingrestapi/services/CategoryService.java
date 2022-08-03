package com.springframework.restapi.onlineshoppingrestapi.services;

import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.CategoryDTO;
import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.ProductDTO;
import com.springframework.restapi.onlineshoppingrestapi.domain.Product;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryById(Long id);

    List<ProductDTO> getProductsByCategory(Long categoryId);

    ProductDTO createProductByCategory(Long categoryId, ProductDTO productDTO);

    CategoryDTO create(CategoryDTO categoryDTO);

    CategoryDTO update(Long id, CategoryDTO categoryDTO);

    CategoryDTO patch(Long id, CategoryDTO categoryDTO);

    void deleteById(Long id);


}
