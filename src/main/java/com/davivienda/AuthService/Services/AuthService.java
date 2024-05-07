package com.davivienda.AuthService.Services;

import com.davivienda.AuthService.Contoller.AuthController;
import com.davivienda.AuthService.Model.Usuario;
import com.davivienda.AuthService.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private static final Logger log = LoggerFactory.getLogger(AuthService.class);

    @Autowired
    UserRepository repository;

    public String validateClave(String username, String password) {
        Optional<Usuario> optional = repository.findById(username);
        if(optional.isEmpty()){
            log.debug("Usuario no encontrado en la DB", username);
            return null;
        }
        Usuario usuario = optional.get();
        if(usuario.getPassword().equals(password)){
            return usuario.getTwoStepAuth();
        }
        log.debug("Password incorrecta", username);
        return null;
    }
}
