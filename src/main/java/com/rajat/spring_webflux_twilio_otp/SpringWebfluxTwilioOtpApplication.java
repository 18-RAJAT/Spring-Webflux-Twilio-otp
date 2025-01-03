package com.rajat.spring_webflux_twilio_otp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class SpringWebfluxTwilioOtpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebfluxTwilioOtpApplication.class, args);
	}
}
