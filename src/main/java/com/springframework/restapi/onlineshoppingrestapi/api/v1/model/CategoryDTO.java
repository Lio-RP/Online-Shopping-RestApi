package com.springframework.restapi.onlineshoppingrestapi.api.v1.model;

import com.springframework.restapi.onlineshoppingrestapi.domain.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    @Schema(required = true)
    private String description;

    private List<ProductDTO> products = new ArrayList<>();
}
