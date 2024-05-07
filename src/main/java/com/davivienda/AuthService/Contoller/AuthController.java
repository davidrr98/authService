package com.davivienda.AuthService.Contoller;

import com.davivienda.AuthService.Model.AuthResponse;
import com.davivienda.AuthService.Model.RequestAuthOTP;
import com.davivienda.AuthService.Model.RequestLoginClave;
import com.davivienda.AuthService.Services.AuthService;
import com.davivienda.AuthService.Services.OTPService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


@RestController
public class AuthController {


    @Autowired
    AuthService authService;

    @Autowired
    OTPService otpService;

    //Validar login con usuario y clave
    @PostMapping("/api/v1/login-clave")
    private ResponseEntity<AuthResponse> loginClave(@RequestBody RequestLoginClave requestLoginClave)
    {

        boolean loginExitoso = authService.validateClave(requestLoginClave.getUsername(), requestLoginClave.getPassword());
        AuthResponse authResponse = new AuthResponse();
        if(loginExitoso){
            authResponse.setFinishAuth(false);
            authResponse.setNextStepAuth("OTP");
            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(authResponse, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/api/v1/auth-otp")
    private ResponseEntity<AuthResponse> authOTP(@RequestBody RequestAuthOTP requestAuthOTP)
    {

        boolean loginExitoso = otpService.validateOTP(requestAuthOTP.getUsername(), requestAuthOTP.getOtp());
        AuthResponse authResponse = new AuthResponse();
        if(loginExitoso){
            authResponse.setFinishAuth(true);
            authResponse.setRedirectTo("www.google.com");
            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(authResponse, HttpStatus.UNAUTHORIZED);
    }




}
