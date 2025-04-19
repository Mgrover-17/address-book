package com.bridgelabz.address_book.DTO;

import com.bridgelabz.address_book.models.AddressBook;
import lombok.Data;

@Data
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String addressBookCreateSuccessfully, Object book) {
        this.message=addressBookCreateSuccessfully;
        this.data=book;
    }
}
