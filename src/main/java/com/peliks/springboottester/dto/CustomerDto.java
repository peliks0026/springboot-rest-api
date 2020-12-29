package com.peliks.springboottester.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CustomerDto {

    private Long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private List<AddressDto> addresses;
}
