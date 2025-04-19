package com.bridgelabz.address_book.services;

import com.bridgelabz.address_book.DTO.AddressBookDTO;
import com.bridgelabz.address_book.models.AddressBook;
import com.bridgelabz.address_book.repositories.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookImpl implements IAddressBookService{

    @Autowired
    private AddressBookRepository addressBookRepository;

    public AddressBook createAddressBook(AddressBookDTO addressBookDTO){
        AddressBook book=new AddressBook(addressBookDTO);
        System.out.println("saving address book");
        return addressBookRepository.save(book);
    }

    @Override
    public List<AddressBook>getAllAddressBook() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBook getAddressBookById(int id) {
        return addressBookRepository.findById((long) id).orElseThrow(()-> new RuntimeException("No address book found with id: " + id));
    }

    @Override
    public List<AddressBook>getAddressesByCountry(String country) {
        return addressBookRepository.findByCountry(country);
    }

    @Override
    public String deleteAddressBook(int id) {
         addressBookRepository.deleteById((long) id);
         return "AddressBook deleted";
    }

    @Override
    public String deleteAllAddressBook() {
        addressBookRepository.deleteAll();
        return "All address book deleted";
    }

    @Override
    public AddressBook updateAddressBook(int id, AddressBookDTO addressBookDTO) {
        AddressBook book=addressBookRepository.findById((long) id).orElseThrow(()->new RuntimeException("AddressBook not found"));
        book.setAddress(addressBookDTO.getAddress());
        book.setCity(addressBookDTO.getCity());
        book.setState(addressBookDTO.getState());
        book.setZip(addressBookDTO.getZip());
        book.setCountry(addressBookDTO.getCountry());
        book.setEmail(addressBookDTO.getEmail());
        book.setName(addressBookDTO.getName());
        book.setPhoneNumber(addressBookDTO.getPhoneNumber());
        return addressBookRepository.save(book);
    }
}
