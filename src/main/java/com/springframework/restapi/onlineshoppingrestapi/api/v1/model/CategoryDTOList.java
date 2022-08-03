package com.springframework.restapi.onlineshoppingrestapi.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTOList {

    List<CategoryDTO> categories;
}
