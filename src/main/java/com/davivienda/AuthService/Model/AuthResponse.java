package com.davivienda.AuthService.Model;

import java.util.Date;

public class AuthResponse {

    private boolean finishAuth;
    private String nextStepAuth;
    private Date trasactionDate;
    private String redirectTo;

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
