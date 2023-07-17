package com.example.BlogMode.service.Impl;

import com.example.BlogMode.model.Customer;
import com.example.BlogMode.payload.CustomerDto;
import com.example.BlogMode.repository.CustomerRepo;
import com.example.BlogMode.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public CustomerDto addDetails(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        Optional<Customer> byId = customerRepo.findById(customer.getId());
        if(byId.isPresent())
        {
            return null;
        }
        Customer newCustomer = customerRepo.save(customer);
        return modelMapper.map(newCustomer,CustomerDto.class);
    }
}
