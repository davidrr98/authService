package com.davivienda.AuthService.Repository;

import com.davivienda.AuthService.Model.OTP;
import com.davivienda.AuthService.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OTPRepository extends JpaRepository<OTP, Long> {

    @Query("SELECT otp FROM OTP otp WHERE otp.username = ?1 and otp.active order by otp.expirationDate  desc limit 1")
    List<OTP> findByUsername(String username);

}
