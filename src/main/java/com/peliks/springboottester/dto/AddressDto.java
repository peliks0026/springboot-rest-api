package com.peliks.springboottester.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
public class AddressDto implements Serializable {

    private String street;
    private String country;
}
