package com.peliks.springboottester.dto;

import com.peliks.springboottester.entity.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    private CustomerMapper() {

    }

    public static CustomerDto convertToCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .middleName(customer.getMiddleName())
                .lastName(customer.getLastName())
                .addresses(customer.getAddresses().stream()
                        .map(AddressMapper::convertToAddressDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public static Customer convertToCustomerEntity(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .firstName(customerDto.getFirstName())
                .middleName(customerDto.getMiddleName())
                .lastName(customerDto.getLastName())
                .build();

        List<AddressDto> addresses = customerDto.getAddresses();
        if (addresses != null && !addresses.isEmpty()) {
            addresses.forEach(addressDto -> customer.addAddress(AddressMapper.convertToAddressEntity(addressDto)));
        }

        return customer;
    }

}
