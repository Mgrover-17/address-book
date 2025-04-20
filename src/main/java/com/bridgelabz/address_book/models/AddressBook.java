package com.bridgelabz.address_book.models;

import com.bridgelabz.address_book.DTO.AddressBookDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String country;
    private String email;

    public AddressBook(AddressBookDTO addressBookDTO){

        this.name=addressBookDTO.getName();
        this.address=addressBookDTO.getAddress();
        this.city=addressBookDTO.getCity();
        this.state=addressBookDTO.getState();
        this.zip=addressBookDTO.getZip();
        this.phoneNumber=addressBookDTO.getPhoneNumber();
        this.country=addressBookDTO.getCountry();
        this.email=addressBookDTO.getEmail();

    }
}
