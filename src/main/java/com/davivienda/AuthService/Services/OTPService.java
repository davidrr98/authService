package com.davivienda.AuthService.Services;

import com.davivienda.AuthService.Model.OTP;
import com.davivienda.AuthService.Repository.OTPRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class OTPService {

    private static final Logger log = LoggerFactory.getLogger(OTPService.class);

    @Autowired
    OTPRepository repository;

    @Autowired
    NotificacionesService notificacionesService;

    private Random r = new Random( System.currentTimeMillis() );

    public void generateOTP(String username){
        List<OTP> otps = repository.findByUsername(username);
        if(!otps.isEmpty()){
            OTP otp_db = otps.getFirst();
            otp_db.setActive(false);
            repository.save(otp_db);
        }

        OTP otp = new OTP(username,Integer.toString(10000 + r.nextInt(20000)));
        notificacionesService.notificacionSMS("Tu codigo para iniciaar sesión es "+otp.getOtp());
        log.debug("OTP Enviado con exito");
        repository.save(otp);
    }

    public boolean validateOTP(String username, String otp) {
        List<OTP> otps = repository.findByUsername(username);
        if(!otps.isEmpty()){
            OTP otp_db = otps.getFirst();
            if(otp_db.getExpirationDate().after(new Date())){
                if(otp_db.getOtp().equals(otp)){
                    otp_db.setUsedDate(new Date());
                    otp_db.setActive(false);
                    repository.save(otp_db);
                    return true;
                }
                log.debug("OTP no coincide", otp);
            }else{
                log.debug("OTP vencido");
            }
        }
        log.debug("No se encuentra OTP activo para el usuario");
        return false;
    }
}
