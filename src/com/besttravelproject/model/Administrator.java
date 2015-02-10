package com.besttravelproject.model;

/**
 * Created by А on 08.01.15.
 */
public class Administrator extends User{
    String login;
    String password;

    public Administrator() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
