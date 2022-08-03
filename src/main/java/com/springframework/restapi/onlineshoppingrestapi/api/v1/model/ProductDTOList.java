package com.springframework.restapi.onlineshoppingrestapi.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTOList {

    List<ProductDTO> products;
}
