package com.bridgelabz.address_book.services;

import com.bridgelabz.address_book.DTO.AddressBookDTO;
import com.bridgelabz.address_book.models.AddressBook;

import java.util.List;

public interface IAddressBookService {
    AddressBook createAddressBook(AddressBookDTO addressBookDTO);
    List<AddressBook>getAllAddressBook();
    AddressBook getAddressBookById(int id);
    List<AddressBook>getAddressesByCountry(String country);
    String deleteAddressBook(int id);
    String deleteAllAddressBook();
    AddressBook updateAddressBook(int id, AddressBookDTO addressBookDTO);
}
