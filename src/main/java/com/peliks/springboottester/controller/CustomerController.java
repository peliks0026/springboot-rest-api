package com.peliks.springboottester.controller;

import com.peliks.springboottester.dto.CustomerDto;
import com.peliks.springboottester.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable(name = "id") Long id) {
        return customerService.getCustomer(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCustomer(@RequestBody CustomerDto customerDto) {
        customerService.saveCustomer(customerDto);
    }

}
