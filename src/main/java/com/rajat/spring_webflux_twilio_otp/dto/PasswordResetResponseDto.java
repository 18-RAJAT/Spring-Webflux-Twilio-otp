package com.rajat.spring_webflux_twilio_otp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//Generates a constructor with parameters for all fields.
@NoArgsConstructor//Generates a no-argument constructor reducing boilerplate code in Java classes.
public class PasswordResetResponseDto {

    private OtpStatus status;
    private String message;
}
