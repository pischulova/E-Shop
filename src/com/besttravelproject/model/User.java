package com.besttravelproject.model;

/**
 * Created by А on 09.02.15.
 */
public abstract class User {
    String login;
    String password;

    public User() {
    }
    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
