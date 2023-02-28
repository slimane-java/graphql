package com.example.demo.mappers;

import com.example.demo.dto.CustomerInput;
import com.example.demo.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface CustomerMapper {
    Customer mapToEntity(CustomerInput customerInput);
    CustomerInput mapToDto(Customer customer);
    List<CustomerInput> mapListToDto(List<Customer> customers);
}
