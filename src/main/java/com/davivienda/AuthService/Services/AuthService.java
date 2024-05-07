package com.davivienda.AuthService.Services;

import com.davivienda.AuthService.Model.Usuario;
import com.davivienda.AuthService.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UserRepository repository;

    public String validateClave(String username, String password) {
        Optional<Usuario> optional = repository.findById(username);
        if(optional.isEmpty()){
            return null;
        }
        Usuario usuario = optional.get();
        if(usuario.getPassword().equals(password)){
            return usuario.getTwoStepAuth();
        }
        return null;
    }
}
