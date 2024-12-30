package com.rajat.spring_webflux_twilio_otp.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import com.twilio.Twilio;

@Configuration
public class TwilioConfig {

    @Value("${twilio.account_sid}")
    private String accountSid;

    @Value("${twilio.auth_token}")
    private String authToken;

    @Value("${twilio.trial_number}")
    private String trialNumber;

    @PostConstruct
    public void init() {
        Twilio.init(accountSid, authToken);
    }

    public String getTrialNumber() {
        return trialNumber;
    }
}
