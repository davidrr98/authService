package com.davivienda.AuthService.Contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/help-check")
public class HelpCheckContoller {

    @GetMapping
    public String helpCheck(){
        return "OK";
    }


}
