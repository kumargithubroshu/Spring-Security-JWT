package com.example.BlogMode.controller;

import com.example.BlogMode.payload.CustomerDto;
import com.example.BlogMode.service.CustomerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/form")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    private Logger logger= LoggerFactory.getLogger(CustomerController.class);

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@RequestParam("file")MultipartFile multipartFile, @RequestParam("userData") String userData)
            throws JsonProcessingException {

        logger.info("logger started");
        logger.info("file information {} ", multipartFile.getOriginalFilename());
        logger.info("customer : {} ",userData);

        CustomerDto customerDto = objectMapper.readValue(userData, CustomerDto.class);

        CustomerDto customerDto1 = customerService.addDetails(customerDto);

        return new ResponseEntity<>(customerDto1, HttpStatus.OK);
    }
}
