package com.example.demo.service;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImp implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setContactRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer login(String username, String password) {
        return getCustomerByNameAndPassword(username, password);
    }

    @Override
    public Customer getCustomerByNameAndPassword(String username, String password) {

        return customerRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void signUp(Customer customer) {
        customerRepository.save(customer);
    }
}