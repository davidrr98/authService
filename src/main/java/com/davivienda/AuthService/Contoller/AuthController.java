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


@RestController
public class AuthController {


    @Autowired
    AuthService authService;

    @Autowired
    OTPService otpService;

    @PostMapping("/api/v1/login-clave")
    private ResponseEntity<AuthResponse> loginClave(@RequestBody RequestLoginClave requestLoginClave)
    {

        boolean loginExitoso = authService.validateClave(requestLoginClave.getUsername(), requestLoginClave.getPassword());
        AuthResponse authResponse = new AuthResponse();
        if(loginExitoso){
            authResponse.setSuccess(true);
            authResponse.setUsername(requestLoginClave.getUsername());
            authResponse.setMessage("Login exitoso");

            authResponse.setFinishAuth(false);
            authResponse.setNextStepAuth("OTP");
            otpService.generateOTP(requestLoginClave.getUsername());
            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        }
        authResponse.setSuccess(false);
        authResponse.setUsername(requestLoginClave.getUsername());
        authResponse.setMessage("Credenciales erroneas");
        return new ResponseEntity<>(authResponse, HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/api/v1/auth-otp")
    private ResponseEntity<AuthResponse> authOTP(@RequestBody RequestAuthOTP requestAuthOTP)
    {

        boolean loginExitoso = otpService.validateOTP(requestAuthOTP.getUsername(), requestAuthOTP.getOtp());
        AuthResponse authResponse = new AuthResponse();
        if(loginExitoso){
            authResponse.setSuccess(true);
            authResponse.setUsername(requestAuthOTP.getUsername());
            authResponse.setMessage("Validación OTP exitosa");
            authResponse.setFinishAuth(true);
            authResponse.setRedirectTo("www.google.com");
            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        }
        authResponse.setSuccess(false);
        authResponse.setUsername(requestAuthOTP.getUsername());
        authResponse.setMessage("OTP incorrecto");
        return new ResponseEntity<>(authResponse, HttpStatus.UNAUTHORIZED);
    }




}
