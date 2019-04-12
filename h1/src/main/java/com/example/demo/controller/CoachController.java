package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.domain.Coach;
import com.example.demo.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CoachController {

    @Autowired
    CoachService coachService;

    @RequestMapping(value = "/coach_signup", method = RequestMethod.POST)
    @ResponseBody
    public String signUp(@RequestParam("username") String username, @RequestParam("password") String password,
                         @RequestParam("mobileNum") String mobileNum, @RequestParam("address") String address) {
        System.out.println("---------------------------------------------->");
        Coach c = new Coach();
        c.setAddress(address);
        c.setMobileNum(mobileNum);
        c.setPassword(password);
        c.setUsername(username);
        coachService.signUp(c);
        return JSON.toJSONString(c);
    }

    @RequestMapping(value = "/coach_signin", method = RequestMethod.POST)
    @ResponseBody
    public String singIn(@RequestParam String username, @RequestParam String password) {
        Coach c = coachService.login(username, password);
        return JSON.toJSONString(c);
    }

}