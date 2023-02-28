package com.example.demo.api;

import com.example.demo.dto.CustomerInput;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import com.example.demo.services.CustomerServices;
import com.google.gson.Gson;
import com.netflix.graphql.dgs.*;
import com.netflix.graphql.dgs.DgsMutation;
import lombok.RequiredArgsConstructor;

import java.util.LinkedHashMap;
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
//    @DgsQuery(field = "customers")
//    public List<Customer> allCustomer(){
//        return customerServices.customerList();
//    }

    @DgsData(parentType = "MutationResolver")
    public Customer createCustomer(@InputArgument Map<Object, Object> input){
        String customerInput1 = gson.toJson(input, Map.class);
        System.out.println("customerInput1" + customerInput1);
        CustomerInput customerInput2 = gson.fromJson(customerInput1, CustomerInput.class);
        System.out.println("customerInput2" + customerInput2.getGender());
        return customerServices.saveCustomer(customerInput2);
    }


}
