package com.bridgelabz.address_book.controllers;

import com.bridgelabz.address_book.DTO.AddressBookDTO;
import com.bridgelabz.address_book.DTO.ResponseDTO;
import com.bridgelabz.address_book.models.AddressBook;
import com.bridgelabz.address_book.services.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/address-book")
public class AddressBookController {

    @Autowired
    private IAddressBookService addressBookService;

    @GetMapping("/")
    public String index() {
        return "Welcome to AddressBook Service";
    }

    @GetMapping("/getAllAddress")
    public ResponseEntity<ResponseDTO> getAllAddressBook() {
        log.info("get req by getAllAddressBook");
        List<AddressBook> addressBookList = addressBookService.getAllAddressBook();
        List<AddressBookDTO> addressBookDTO=new ArrayList<>();
        for(AddressBook book:addressBookList){
            AddressBookDTO bookDTO=new AddressBookDTO(book);
            addressBookDTO.add(bookDTO);
        }


        ResponseDTO responseDTO = new ResponseDTO("All Address Books: ", addressBookDTO);
        log.info("getAllAddressBook");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAddressByCountry/{country}")
    public ResponseEntity<ResponseDTO>getAddressBookByCountry(@PathVariable String country) {
        log.info("get req by country");
        List<AddressBook> addressBook=addressBookService.getAddressesByCountry(country);

        List<AddressBookDTO> addressBookDTO=new ArrayList<>();
        for(AddressBook book:addressBook){
            AddressBookDTO bookDTO=new AddressBookDTO(book);
            addressBookDTO.add(bookDTO);
        }


        ResponseDTO responseDTO=new ResponseDTO("Address Book by country: ", addressBookDTO);
        log.info("getAddressBookByCountry");
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getAddress/{id}")
    public ResponseEntity<ResponseDTO> getAddress(@PathVariable int id) {
        log.info("get req by getAddress by id");
        AddressBook addressBook = addressBookService.getAddressBookById(id);
        AddressBookDTO addressBookDTO = new AddressBookDTO(addressBook);

        ResponseDTO responseDto=new ResponseDTO("Address Book: ", addressBookDTO);
        log.info("getAddress : " + addressBook);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO>createAddressBook(@RequestBody AddressBookDTO addressBookDTO){

        log.info("Inside createAddressBook");
        AddressBook book=addressBookService.createAddressBook(addressBookDTO);
        ResponseDTO responseDTO=new ResponseDTO("address book create successfully",book);

        log.info("ResponseDTO:"+responseDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO>deleteAddressBook(@PathVariable int id){
        log.info("Inside deleteAddressBook");
        String message=addressBookService.deleteAddressBook(id);
        ResponseDTO responseDTO=new ResponseDTO("address book delete successfully",message);
        log.info("ResponseDTO:"+responseDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllAddress")
    public ResponseEntity<ResponseDTO>deleteAllAddressBook(){
        log.info("Inside deleteAllAddressBook");
        String message=addressBookService.deleteAllAddressBook();
        ResponseDTO responseDTO=new ResponseDTO("All address books deleted successfully",message);
        log.info("ResponseDTO:"+responseDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO>updateAddressBook(@PathVariable int id, @RequestBody AddressBookDTO addressBookDTO){
        log.info("Inside updateAddressBook");
        AddressBook book=addressBookService.updateAddressBook(id, addressBookDTO);
        AddressBookDTO bookDTO=new AddressBookDTO(book);
        ResponseDTO responseDTO=new ResponseDTO("address book updated successfully",bookDTO);
        log.info("ResponseDTO:"+responseDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
