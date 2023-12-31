package com.example.phonebook.controller;

import com.example.phonebook.model.PhoneBook;
import com.example.phonebook.repository.PhoneBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/pbook")
public class PhoneBookController {

    final PhoneBookRepository phoneBookRepository;

    public PhoneBookController(PhoneBookRepository phoneBookRepository) {
        this.phoneBookRepository = phoneBookRepository;
    }

    // http GET http://localhost:8080/pbook/find
    // http GET http://localhost:8080/pbook/find?firstName=Flo
    @GetMapping("/find")
    public ResponseEntity<List<PhoneBook>> getPhoneBook(@RequestParam(required = false) String firstName) {
        log.info("First Name: " + firstName);
        try {
            List<PhoneBook> phoneBook = new ArrayList<>();
            if (firstName == null)
                phoneBook.addAll(phoneBookRepository.findAll());
            else
                phoneBook.addAll(phoneBookRepository.findPhoneBooksByFirstNameStartsWithIgnoreCase(firstName));
            if (phoneBook.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(phoneBook, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

