package com.example.andyvsfeign.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient("phonebook")
public interface AndyVsFeignClient {
        @RequestMapping(value = "/pbook/find", method = GET)
        public ResponseEntity<List<?>> getPhoneBook(@RequestParam(required = false) String firstName);

}
