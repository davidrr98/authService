package com.davivienda.AuthService.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "twoStepAuth")
    private String twoStepAuth;

    public Usuario(String password, String username, String twoStepAuth) {
        this.password = password;
        this.username = username;
        this.twoStepAuth = twoStepAuth;
    }

    public Usuario() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTwoStepAuth() {
        return twoStepAuth;
    }

    public void setTwoStepAuth(String twoStepAuth) {
        this.twoStepAuth = twoStepAuth;
    }

}
