package com.example.demo.mappers;

import com.example.demo.entity.Customer;
import com.example.demo.generated.types.CustomerEdit;
import com.example.demo.generated.types.CustomerInput;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface CustomerMapper {
    Customer mapToEntity(CustomerInput customerInput);
    CustomerInput mapToDto(Customer customer);
    List<CustomerInput> mapListToDto(List<Customer> customers);

    void update(CustomerEdit customerEdit, @MappingTarget Customer customer);
}
