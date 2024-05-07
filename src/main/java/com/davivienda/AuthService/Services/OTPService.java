package com.davivienda.AuthService.Services;

import com.davivienda.AuthService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OTPService {

    @Autowired
    UserRepository repository;

    public void generateOTP(String username){

    }

    public boolean validateOTP(String username, String otp) {
        return "12345".equals(otp);
    }
}
