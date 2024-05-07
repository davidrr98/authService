package com.davivienda.AuthService.Services;

import com.davivienda.AuthService.Model.OTP;
import com.davivienda.AuthService.Model.Usuario;
import com.davivienda.AuthService.Repository.OTPRepository;
import com.davivienda.AuthService.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PalabrasService {

    private static final Logger log = LoggerFactory.getLogger(PalabrasService.class);

    @Autowired
    UserRepository repository;

    @Autowired
    NotificacionesService notificacionesService;


    public boolean validatePalabras(String username, String palabra, String frase, String llave) {
        Optional<Usuario> optional = repository.findById(username);
        if(optional.isEmpty()){
            log.debug("Usuario no encontrado, ",username);
            return false;
        }
        Usuario usuario = optional.get();
        if(!usuario.getTwoStepAuth().equals("PALABRAS")){
            log.debug("Usuario con otro metodo de autenticacion, ",usuario.getTwoStepAuth());
            return false;
        };


        if(palabra.equals("carro")){
            if(frase.equals("tengo un carro")){
                if(llave.equals("ford")){
                    return true;
                }
            }
        }
        log.debug("Los parametros no coinciden");
        return false;
    }

}
