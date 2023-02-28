package com.example.demo.dto;

import com.example.demo.enums.AccountStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountInput {
    private  Integer number;
    private  Float balance;
    private AccountStatus accountStatus;
}
