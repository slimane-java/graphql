package com.example.demo.api;

import com.example.demo.entity.Customer;
import com.example.demo.generated.types.CustomerEdit;
import com.example.demo.generated.types.CustomerInput;
import com.example.demo.services.CustomerServices;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.netflix.graphql.dgs.*;
import com.netflix.graphql.dgs.DgsMutation;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@DgsComponent
@RequiredArgsConstructor
public class CustomerDataFetcher {
    private final CustomerServices customerServices;
    private final Gson gson = new Gson();

//    @DgsData(parentType = "Customer", field = "accounts")
//    public List<Account> accounts(DgsDataFetchingEnvironment dgsDataFetchingEnvironment){
//        Customer customer = dgsDataFetchingEnvironment.getSource();
//        return customer.getAccounts();
//    }
    @DgsQuery(field = "customers")
    public List<Customer> customers(){
        return customerServices.customerList();
    }

    @DgsQuery(field = "customersById")
    public Customer customersById(Long id){
        return customerServices.findById(id);
    }

    @DgsMutation
    public Customer createCustomer(CustomerInput input){
        if(input == null) {
            System.out.println("null null");
        }
        return customerServices.saveCustomer(input);
    }

    @DgsMutation
    public Customer updateCustomer(Long id, CustomerEdit input){
        if(input == null) {
            System.out.println("null null");
        }
        return customerServices.editCustomer(id,input);
    }

//    @DgsMutation
//    public Customer updateCustomer(Long id, @InputArgument("input") CustomerInput inputMap){
//        return customerServices.saveCustomer(inputMap);
//    }




}
