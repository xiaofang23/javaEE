package com.example.demo.service;

import com.example.demo.domain.Coach;
import com.example.demo.repository.CoachRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CoachServiceImp implements CoachService {

    private CoachRepository coachRepository;

    @Autowired
    public void setContactRepository(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    @Override
    public Coach login(String username, String password) {
        return getCustomerByNameAndPassword(username, password);
    }

    @Override
    public Coach getCustomerByNameAndPassword(String username, String password) {

        return coachRepository.findByUsernameAndPassword(username, password);
    }

    @Override
    public void signUp(Coach coach) {
        coachRepository.save(coach);
    }
}