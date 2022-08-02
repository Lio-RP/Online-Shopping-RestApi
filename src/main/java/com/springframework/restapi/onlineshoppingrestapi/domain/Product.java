package com.springframework.restapi.onlineshoppingrestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String brand;
    private float price;
    private int inStock;
    private Byte[] image;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
