package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerInput {
    private String name;
    private String gender;
    private String mail;
    private String tel;
    private List<AccountInput> accounts;
}
