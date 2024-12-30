package com.rajat.spring_webflux_twilio_otp.dto;

import lombok.Data;

@Data
public class PasswordResetRequestDto {
    //encapsulate
    private String phoneNumber;
    private String userName;
    private String oneTimePassword;
}
