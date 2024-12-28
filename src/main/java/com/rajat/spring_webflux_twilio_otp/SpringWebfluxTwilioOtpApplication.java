package com.rajat.spring_webflux_twilio_otp;

import com.twilio.Twilio;
import com.rajat.spring_webflux_twilio_otp.config.TwilioConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebfluxTwilioOtpApplication {


	@Autowired
	private TwilioConfig twilioConfig;
	@PostConstruct
	public void initTwilio()
	{
		Twilio.init(twilioConfig.getAccountSid(),twilioConfig.getAuthToken());
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxTwilioOtpApplication.class, args);
	}

}