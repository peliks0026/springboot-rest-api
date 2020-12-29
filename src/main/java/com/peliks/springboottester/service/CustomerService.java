package com.peliks.springboottester.service;

import com.peliks.springboottester.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto getCustomer(Long id);

    List<CustomerDto> getAllCustomers();

    void saveCustomer(CustomerDto customer);
}
