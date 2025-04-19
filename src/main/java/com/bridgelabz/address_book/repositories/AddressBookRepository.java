package com.bridgelabz.address_book.repositories;

import com.bridgelabz.address_book.models.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook,Long> {
    @Query(value = "SELECT * FROM address_book WHERE country = :country ", nativeQuery = true)
    public List<AddressBook> findByCountry(String country);
}
