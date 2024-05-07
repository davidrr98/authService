package com.davivienda.AuthService.Model;

import jakarta.persistence.*;
import org.hibernate.type.descriptor.DateTimeUtils;

import java.util.Date;

@Entity
@Table(name = "otp")
public class OTP {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "otp")
    private String otp;

    @Column(name = "expirationDate")
    private Date expirationDate;

    @Column(name = "active")
    private boolean active;

    @Column(name = "usedDate")
    private Date usedDate;

    public OTP(){}

    public OTP(Long id, String username, String otp, Date expirationDate, Date usedDate, boolean active) {
        this.id = id;
        this.username = username;
        this.otp = otp;
        this.expirationDate = expirationDate;
        this.usedDate = usedDate;
        this.active = active;
    }

    public OTP(String username, String otp) {

        int expiration_otp = 10;

        this.username = username;
        this.otp = otp;
        this.expirationDate = new Date((new Date().getTime()) + (1000 * 60 * expiration_otp));
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getUsedDate() {
        return usedDate;
    }

    public void setUsedDate(Date usedDate) {
        this.usedDate = usedDate;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
