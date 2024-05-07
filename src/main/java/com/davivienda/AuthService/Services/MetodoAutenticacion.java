package com.davivienda.AuthService.Services;

import org.springframework.stereotype.Service;

public abstract  class  MetodoAutenticacion{

    public boolean prevalidaciones(){
        return true;
    }

    abstract public boolean validacion_input(String user, String password);

}
