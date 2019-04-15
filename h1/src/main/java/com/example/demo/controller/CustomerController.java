package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.primary.Customer;
import com.example.demo.service.primary.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/customerSignUp", method = RequestMethod.POST)
    public String signUp(@RequestParam String username, @RequestParam String password, @RequestParam String mobileNum,
                         @RequestParam String address) {
        Customer c = new Customer();
        c.setAddress(address);
        c.setMobileNum(mobileNum);
        c.setPassword(password);
        c.setUsername(username);
        customerService.signUp(c);
        return "contact.html";
    }

    @RequestMapping(value = "/customerSignIn", method = RequestMethod.POST)
    public String singIn(@RequestParam String username, @RequestParam String password) {
        Customer c = customerService.login(username, password);
        return "index.html";
    }

}