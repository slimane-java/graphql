package com.example.demo.services;

import com.example.demo.dao.AccountRepo;
import com.example.demo.dao.CustomerRepo;
import com.example.demo.dto.CustomerInput;
import com.example.demo.entity.Customer;
import com.example.demo.mappers.AccountMapper;
import com.example.demo.mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerServices {
    private final CustomerRepo customerRepo;
    private final AccountRepo accountRepo;
    private final AccountMapper accountMapper;
    private final CustomerMapper customerMapper;

    public Customer saveCustomer(CustomerInput customerInput){
        Customer customer = customerMapper.mapToEntity(customerInput);
        customer.getAccounts().forEach(account -> System.out.println("account " + account.getBalance()));
        return customerRepo.save(customer);
    }

    public List<Customer> customerList(){
        return customerRepo.findAll();
    }
}
