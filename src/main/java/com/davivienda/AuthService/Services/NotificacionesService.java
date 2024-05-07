package com.davivienda.AuthService.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificacionesService {

    private static final Logger log = LoggerFactory.getLogger(NotificacionesService.class);

    public void notificacionSMS(String msj){
        log.info(msj);
    }
}
