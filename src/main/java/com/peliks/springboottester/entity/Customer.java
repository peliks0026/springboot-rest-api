package com.peliks.springboottester.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address) {
        this.addresses.add(address);
        address.setCustomer(this);
    }

}
