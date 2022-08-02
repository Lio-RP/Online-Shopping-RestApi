package com.springframework.restapi.onlineshoppingrestapi.api.v1.mapper;

import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.ShoppingCartDTO;
import com.springframework.restapi.onlineshoppingrestapi.domain.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShoppingCartMapper {

    ShoppingCartMapper INSTANCE = Mappers.getMapper(ShoppingCartMapper.class);

    ShoppingCartDTO shoppingCartToShoppingCartDTO(ShoppingCart shoppingCart);


    @Mapping(target = "id", ignore = true)
    ShoppingCart shoppingCartDtoToShoppingCart(ShoppingCartDTO shoppingDTO);
}
