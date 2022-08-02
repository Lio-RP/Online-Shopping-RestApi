package com.springframework.restapi.onlineshoppingrestapi.api.v1.mapper;

import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.ProductDTO;
import com.springframework.restapi.onlineshoppingrestapi.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO productToProductDTO(Product product);

    @Mapping(target = "id", ignore = true)
    Product productDTOToProduct(ProductDTO productDTO);
}
