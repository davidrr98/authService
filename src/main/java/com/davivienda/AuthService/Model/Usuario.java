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

    public Usuario(String password, String username) {
        this.password = password;
        this.username = username;
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
}
