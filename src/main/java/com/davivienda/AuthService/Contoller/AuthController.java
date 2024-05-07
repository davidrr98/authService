package com.davivienda.AuthService.Contoller;

import com.davivienda.AuthService.Model.AuthResponse;
import com.davivienda.AuthService.Model.RequestAuthOTP;
import com.davivienda.AuthService.Model.RequestAuthPalabras;
import com.davivienda.AuthService.Model.RequestLoginClave;
import com.davivienda.AuthService.Services.AuthService;
import com.davivienda.AuthService.Services.OTPService;
import com.davivienda.AuthService.Services.PalabrasService;
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

    @Autowired
    PalabrasService palabrasService;

    @PostMapping("/api/v1/login-clave")
    private ResponseEntity<AuthResponse> loginClave(@RequestBody RequestLoginClave requestLoginClave)
    {

        String twofactor = authService.validateClave(requestLoginClave.getUsername(), requestLoginClave.getPassword());
        AuthResponse authResponse = new AuthResponse();
        if(twofactor != null){
            authResponse.setSuccess(true);
            authResponse.setUsername(requestLoginClave.getUsername());
            authResponse.setMessage("Login exitoso");

            authResponse.setFinishAuth(false);
            authResponse.setNextStepAuth(twofactor);
            if(twofactor.equals("OTP")){
                otpService.generateOTP(requestLoginClave.getUsername());
            }
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

    @PostMapping("/api/v1/auth-palabras")
    private ResponseEntity<AuthResponse> authPalabras(@RequestBody RequestAuthPalabras requestAuthPalabras)
    {

        boolean loginExitoso = palabrasService.validatePalabras(requestAuthPalabras.getUsername(),
                requestAuthPalabras.getPalabra(),
                requestAuthPalabras.getFrase(),
                requestAuthPalabras.getLlave());

        AuthResponse authResponse = new AuthResponse();
        if(loginExitoso){
            authResponse.setSuccess(true);
            authResponse.setUsername(requestAuthPalabras.getUsername());
            authResponse.setMessage("Validación Palabras exitosa");
            authResponse.setFinishAuth(true);
            authResponse.setRedirectTo("www.google.com");
            return new ResponseEntity<>(authResponse, HttpStatus.OK);
        }
        authResponse.setSuccess(false);
        authResponse.setUsername(requestAuthPalabras.getUsername());
        authResponse.setMessage("Palabras incorrectas");
        return new ResponseEntity<>(authResponse, HttpStatus.UNAUTHORIZED);
    }




}
