package com.example.springc0423i1.service.auth.request;

public class LoginRequest {
    private String username;

    private String password;

    private String demo;



    public LoginRequest() {
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
