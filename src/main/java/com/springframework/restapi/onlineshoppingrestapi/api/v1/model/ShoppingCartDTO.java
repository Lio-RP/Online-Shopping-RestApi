package com.springframework.restapi.onlineshoppingrestapi.api.v1.model;

import com.springframework.restapi.onlineshoppingrestapi.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {

    private int quantity;
    private float subtotalPrice;
    private Product product;
}
