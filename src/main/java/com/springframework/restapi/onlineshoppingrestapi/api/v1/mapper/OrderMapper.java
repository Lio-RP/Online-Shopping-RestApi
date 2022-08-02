package com.springframework.restapi.onlineshoppingrestapi.api.v1.mapper;

import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.OrderDTO;
import com.springframework.restapi.onlineshoppingrestapi.domain.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO orderToOrderDTO(Order order);

    @Mapping(target = "id", ignore = true)
    Order orderDtoToOrder(OrderDTO orderDTO);
}
