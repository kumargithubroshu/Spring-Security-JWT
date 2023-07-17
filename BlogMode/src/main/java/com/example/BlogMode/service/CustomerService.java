package com.example.BlogMode.service;

import com.example.BlogMode.model.Customer;
import com.example.BlogMode.payload.CustomerDto;

public interface CustomerService {

    CustomerDto addDetails(CustomerDto customerDto);
}
