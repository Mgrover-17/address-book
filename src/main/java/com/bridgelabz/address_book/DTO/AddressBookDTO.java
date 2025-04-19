package com.bridgelabz.address_book.DTO;

import com.bridgelabz.address_book.models.AddressBook;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBookDTO {
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;

    @Pattern(regexp = "\\d{10}", message = "phone number should be of 10 digits")
    private long phoneNumber;

    @Pattern(regexp = "INDIA|india|India", message = "Country should be india only.")
    private String country;
    private String email;

    public AddressBookDTO(AddressBook addressBook) {
        this.name=addressBook.getName();
        this.address=addressBook.getAddress();
        this.city=addressBook.getCity();
        this.state=addressBook.getState();
        this.zip=addressBook.getZip();
        this.phoneNumber=addressBook.getPhoneNumber();
        this.country=addressBook.getCountry();
        this.email=addressBook.getEmail();
    }
}
