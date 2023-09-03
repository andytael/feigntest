package com.example.andyvsfeign.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.andyvsfeign.client.AndyVsFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AndyVsFeignService {

    private final AndyVsFeignClient andyvsfeignClient;

    public ResponseEntity<List<?>> getPhoneBook(@RequestParam(required = false) String firstName) {
        return andyvsfeignClient.getPhoneBook(firstName);
    }
}

