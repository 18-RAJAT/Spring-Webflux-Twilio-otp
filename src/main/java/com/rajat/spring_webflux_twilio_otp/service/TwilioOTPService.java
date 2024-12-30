package com.rajat.spring_webflux_twilio_otp.service;

import com.rajat.spring_webflux_twilio_otp.config.TwilioConfig;
import com.rajat.spring_webflux_twilio_otp.dto.OtpStatus;
import com.rajat.spring_webflux_twilio_otp.dto.PasswordResetRequestDto;
import com.rajat.spring_webflux_twilio_otp.dto.PasswordResetResponseDto;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class TwilioOTPService {

    @Autowired
    private TwilioConfig twilioConfig;

    private final Map<String, String> otpMap = new HashMap<>();

    public Mono<PasswordResetResponseDto> sendOTPForPasswordReset(PasswordResetRequestDto passwordResetRequestDto) {
        try {
            PhoneNumber to = new PhoneNumber(passwordResetRequestDto.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
            String otp = generateOTP();
            String otpMessage = "Dear Customer, your OTP is " + otp + ". Kindly use this code to complete your transaction. Thank you for your trust in our services.";

            // Send OTP message using Twilio API
            Message.creator(to, from, otpMessage).create();

            otpMap.put(passwordResetRequestDto.getUserName(), otp);
            return Mono.just(new PasswordResetResponseDto(OtpStatus.DELIVERED, otpMessage));
        } catch (Exception ex) {
            return Mono.just(new PasswordResetResponseDto(OtpStatus.FAILED, ex.getMessage()));
        }
    }

    public Mono<String> validateOTP(String userInputOtp, String userName) {
        if (userInputOtp.equals(otpMap.get(userName))) {
            otpMap.remove(userName);
            return Mono.just("Valid OTP! Please proceed with your transaction.");
        } else {
            return Mono.error(new IllegalArgumentException("Invalid OTP. Please retry!"));
        }
    }

    private String generateOTP() {
        return new DecimalFormat("000000").format(new Random().nextInt(999999));
    }
}
