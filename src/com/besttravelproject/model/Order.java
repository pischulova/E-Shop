package com.besttravelproject.model;

import java.util.Date;
import java.util.List;

/**
 * Created by А on 08.01.15.
 */
public class Order {
    int id;
    Date date;
    Client client;
    int amount;
    List<Product> products;
    int isApproved;

    public Order() {}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }


}
