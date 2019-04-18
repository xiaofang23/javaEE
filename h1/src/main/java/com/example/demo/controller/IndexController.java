package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

    @RequestMapping(value = {"", "/", "/home"})
    public String index() {
        return "index.html";
    }

    @RequestMapping(value = "/coach")
    public String coach() {
        return "signupforcoach.html";
    }

    @RequestMapping(value="/signInPage")
    public String signPage(){
        return "contact.html";
    }

    @RequestMapping(value="/signUpPage")
    public String signUp(){
        return "signup.html";
    }



}