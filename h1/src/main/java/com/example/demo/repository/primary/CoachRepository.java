package com.example.demo.repository.primary;

import com.example.demo.domain.primary.Coach;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer> {

    @Query(value = "select * from coach where username=?1 and password=?2", nativeQuery = true)
    Coach findByUsernameAndPassword(String username, String password);

    @Query(value = "select * from coach_recom",nativeQuery = true)
    List<Coach> getRecomCoach();
}