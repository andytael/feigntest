package com.example.phonebook.model;

import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "phonebook")
@Data
public class PhoneBook {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long phonebookId;

    @Column(length = 40)
    private String firstName;

    @Column(length = 40)
    private String lastName;

    @Column(length = 12)
    private String phoneNumber;
}
