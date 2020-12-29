package com.peliks.springboottester.dto;

import com.peliks.springboottester.entity.Address;

import java.util.List;

public class AddressMapper {

    private AddressMapper() {

    }

    public static AddressDto convertToAddressDto(Address address) {
        return AddressDto.builder()
                .street(address.getStreet())
                .country(address.getCountry())
                .build();
    }

    public static Address convertToAddressEntity(AddressDto addressDto) {
        return Address.builder()
                .street(addressDto.getStreet())
                .country(addressDto.getCountry())
                .build();
    }

}
