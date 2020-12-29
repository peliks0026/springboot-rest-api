package com.peliks.springboottester.service;

import com.peliks.springboottester.dto.CustomerDto;
import com.peliks.springboottester.dto.CustomerMapper;
import com.peliks.springboottester.exception.CustomerNotFoundException;
import com.peliks.springboottester.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto getCustomer(Long id) {
        return customerRepository.findById(id)
                .map(CustomerMapper::convertToCustomerDto)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("Customer with id %s not found.", id)));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::convertToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        customerRepository.save(CustomerMapper.convertToCustomerEntity(customerDto));
    }

    public void test() {

    }


}
