package com.rajat.spring_webflux_twilio_otp.dto;

public class PasswordResetRequestDto {
    private String phoneNumber;
    private String userName;

    // Getters and Setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
