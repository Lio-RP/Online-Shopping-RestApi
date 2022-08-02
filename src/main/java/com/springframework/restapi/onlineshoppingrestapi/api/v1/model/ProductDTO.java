package com.springframework.restapi.onlineshoppingrestapi.api.v1.model;

import com.springframework.restapi.onlineshoppingrestapi.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private String name;
    private String description;
    private String brand;
    private float price;
    private int inStock;
    private Byte[] image;
    private Category category;
}
