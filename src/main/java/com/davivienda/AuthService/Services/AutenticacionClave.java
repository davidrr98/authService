package com.davivienda.AuthService.Services;

import org.springframework.stereotype.Component;


@Component
public class AutenticacionClave extends MetodoAutenticacion{

    //UserRepository repository;

    @Override
    public boolean validacion_input(String user, String password) {
//       
        return true;
    }
}
