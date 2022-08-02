package com.springframework.restapi.onlineshoppingrestapi.api.v1.model;

import com.springframework.restapi.onlineshoppingrestapi.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {


    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String country;
    private String zipcode;
    private List<Order> orders = new ArrayList<>();
}
