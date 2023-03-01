package com.example.demo.services;

import com.example.demo.dao.AccountRepo;
import com.example.demo.dao.CustomerRepo;
import com.example.demo.entity.Customer;
import com.example.demo.generated.types.CustomerEdit;
import com.example.demo.generated.types.CustomerInput;
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

    public Customer editCustomer(Long id, CustomerEdit customerEdit){
        System.out.println("customerEdit" + customerEdit.getName());
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        customerMapper.update(customerEdit, customer );
        System.out.println("customer customer" + customer.getName());
        System.out.println("customerEdit" + customerEdit.getName());

        return customerRepo.save(customer);
    }


    public List<Customer> customerList(){
        customerRepo.findAll().forEach(customer -> System.out.println(customer.getGender()));
        return customerRepo.findAll();
    }

    public Customer findById(Long id){
        return customerRepo.findById(id).orElseThrow(() -> new RuntimeException("this customer not found "));
    }
}
