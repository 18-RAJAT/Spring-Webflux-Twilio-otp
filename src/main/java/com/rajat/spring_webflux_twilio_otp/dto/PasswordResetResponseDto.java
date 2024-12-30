package com.rajat.spring_webflux_twilio_otp.dto;

public class PasswordResetResponseDto {
    private OtpStatus status;
    private String message;

    public PasswordResetResponseDto(OtpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters and Setters
    public OtpStatus getStatus() {
        return status;
    }

    public void setStatus(OtpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
