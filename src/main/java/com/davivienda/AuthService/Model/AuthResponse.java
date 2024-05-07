package com.davivienda.AuthService.Model;

import java.util.Date;

public class AuthResponse {

    private boolean success;
    private String message;
    private String username;
    private boolean finishAuth;
    private String nextStepAuth;
    private Date trasactionDate;
    private String redirectTo;


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuthResponse() {
        this.trasactionDate = new Date();
    }

    public boolean isFinishAuth() {
        return finishAuth;
    }

    public void setFinishAuth(boolean finishAuth) {
        this.finishAuth = finishAuth;
    }

    public String getNextStepAuth() {
        return nextStepAuth;
    }

    public void setNextStepAuth(String nextStepAuth) {
        this.nextStepAuth = nextStepAuth;
    }

    public Date getTrasactionDate() {
        return trasactionDate;
    }

    public void setTrasactionDate(Date trasactionDate) {
        this.trasactionDate = trasactionDate;
    }

    public String getRedirectTo() {
        return redirectTo;
    }

    public void setRedirectTo(String redirectTo) {
        this.redirectTo = redirectTo;
    }
}
