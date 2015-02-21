package com.besttravelproject.model;

/**
 * Created by А on 08.01.15.
 */
public class Client extends User{
    int id;
    String login;
    String password;
    String name;
    String email;
    String phone;
    Boolean isBad;
    int orderAmount;

    public Client() {
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsBad() {
        return isBad;
    }

    public void setIsBad(Boolean isBad) {
        this.isBad = isBad;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }
}
