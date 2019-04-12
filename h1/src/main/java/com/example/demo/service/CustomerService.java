package com.example.demo.service;

import com.example.demo.domain.Customer;

import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    Customer login(String username, String password);

    Customer getCustomerByNameAndPassword(String username, String password);

    void signUp(Customer customer);
}