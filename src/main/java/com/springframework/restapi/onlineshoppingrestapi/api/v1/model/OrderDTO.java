package com.springframework.restapi.onlineshoppingrestapi.api.v1.model;

import com.springframework.restapi.onlineshoppingrestapi.domain.Customer;
import com.springframework.restapi.onlineshoppingrestapi.domain.Product;
import com.springframework.restapi.onlineshoppingrestapi.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private String orderNumber;
    private LocalDate dateOrdered;
    private int productQuantity;
    private float totalPrice;
    private List<Product> products = new ArrayList<>();
    private OrderStatus status;
    private Customer customer;
}
