package com.davivienda.AuthService.Services;

import com.davivienda.AuthService.Model.OTP;
import com.davivienda.AuthService.Model.Usuario;
import com.davivienda.AuthService.Repository.OTPRepository;
import com.davivienda.AuthService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PalabrasService {

    @Autowired
    UserRepository repository;

    @Autowired
    NotificacionesService notificacionesService;


    public boolean validatePalabras(String username, String palabra, String frase, String llave) {
        Optional<Usuario> optional = repository.findById(username);
        if(optional.isEmpty()){
            return false;
        }
        Usuario usuario = optional.get();
        if(!usuario.getTwoStepAuth().equals("PALABRAS")){
            return false;
        };


        if(palabra.equals("carro")){
            if(frase.equals("tengo un carro")){
                if(llave.equals("ford")){
                    return true;
                }
            }
        }
        return false;
    }

}
