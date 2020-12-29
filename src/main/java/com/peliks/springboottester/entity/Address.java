package com.peliks.springboottester.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn
    private Customer customer;

    private String street;
    private String country;
}
