package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = Coach.COACH)
public class Coach {

    /**
     *
     */
    static final String COACH = "coach";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer coach_id;

    @NotEmpty(message = "User Name is required.")
    private String username;

    @Size(min = 6, max = 20, message = "Password must more than 6  chars and less 20 chars")
    private String password;

    @Size(min = 11, max = 11, message = "Mobile no. must be 11 digits.")
    @Column(name = "mobile_no")
    private String mobileNum;

    @NotEmpty(message = "Address is required.")
    private String address;
    
    /**
     * @return the coach_id
     */
    public Integer getCoach_id() {
        return coach_id;
    }

    /**
     * @param coach_id the coach_id to set
     */
    public void setCoach_id(Integer coach_id) {
        this.coach_id = coach_id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the mobileNum
     */
    public String getMobileNum() {
        return mobileNum;
    }

    /**
     * @param mobileNum the mobileNum to set
     */
    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}   