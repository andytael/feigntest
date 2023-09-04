package com.example.andyvsfeign.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.andyvsfeign.service.AndyVsFeignService;


@RestController
public class AndyVsFeignController {

    final AndyVsFeignService andyVsFeignService;

    public AndyVsFeignController(AndyVsFeignService andyVsFeignService) {
        this.andyVsFeignService = andyVsFeignService;
    }

    /**
     * Find Phonebook entries
     * @param firstName Filter on firstName, left blank all phonebook entries are returned
     * @return A List of phonebook entries and HTTP Status code
     * 
     * http GET :9090/phonebookentries
     * http GET :9090/phonebookentries firstName==flo
     * 
     */
    @GetMapping("/phonebookentries")
    public ResponseEntity<?> getPhoneBook(@RequestParam(required = false) String firstName) {
        return new ResponseEntity<>(andyVsFeignService.getPhoneBook(firstName), HttpStatus.OK);
    }

}