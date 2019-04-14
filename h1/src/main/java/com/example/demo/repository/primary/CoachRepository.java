package com.example.demo.repository.primary;

import com.example.demo.domain.primary.Coach;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {

    @Query(value = "select * from coach where username=?1 and password=?2", nativeQuery = true)
    Coach findByUsernameAndPassword(String username, String password);


}