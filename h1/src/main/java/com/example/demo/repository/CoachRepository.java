package com.example.demo.repository;

import com.example.demo.domain.Coach;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {

    @Query(value = "select * from coach where username=?1 and password=?2", nativeQuery = true)
    public Coach findByUsernameAndPassword(String username, String password);
}