package com.springframework.restapi.onlineshoppingrestapi.api.v1.mapper;

import com.springframework.restapi.onlineshoppingrestapi.api.v1.model.CustomerDTO;
import com.springframework.restapi.onlineshoppingrestapi.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    @Mapping(target = "id", ignore = true)
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
