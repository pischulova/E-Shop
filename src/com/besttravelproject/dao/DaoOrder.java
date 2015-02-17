package com.besttravelproject.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by А on 17.02.15.
 */
public class DaoOrder {
    Connection connection;

    final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/sql_statements");
    final static String ADD_TO_CART = resourceBundle.getString("ADD_TO_CART");
    final static String REMOVE_FROM_CART = resourceBundle.getString("REMOVE_FROM_CART");

    public DaoOrder() {}

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
