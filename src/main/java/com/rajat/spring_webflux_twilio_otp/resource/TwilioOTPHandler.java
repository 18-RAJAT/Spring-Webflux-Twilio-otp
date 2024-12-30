package com.rajat.spring_webflux_twilio_otp.resource;

import com.rajat.spring_webflux_twilio_otp.dto.PasswordResetRequestDto;
import com.rajat.spring_webflux_twilio_otp.dto.PasswordResetResponseDto;
import com.rajat.spring_webflux_twilio_otp.service.TwilioOTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class TwilioOTPHandler {

    @Autowired
    private TwilioOTPService twilioOTPService;

    public Mono<ServerResponse> sendOTP(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(PasswordResetRequestDto.class)
                .flatMap(twilioOTPService::sendOTPForPasswordReset)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> validateOTP(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Map.class)
                .flatMap(body -> {
                    String userInputOtp = (String) body.get("otp");
                    String userName = (String) body.get("userName");
                    return twilioOTPService.validateOTP(userInputOtp, userName);
                })
                .flatMap(message -> ServerResponse.ok().bodyValue(message))
                .onErrorResume(ex -> ServerResponse.badRequest().bodyValue(ex.getMessage()));
    }
}
