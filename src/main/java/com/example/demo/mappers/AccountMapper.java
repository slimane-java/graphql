package com.example.demo.mappers;

import com.example.demo.dto.AccountInput;
import com.example.demo.dto.CustomerInput;
import com.example.demo.entity.Account;
import com.example.demo.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfig.class)
public interface AccountMapper {
    Account mapToEntity(AccountInput accountInput);
    AccountInput mapToDto(Account account);
    List<AccountInput> mapListToDto(List<Account> accounts);
}
