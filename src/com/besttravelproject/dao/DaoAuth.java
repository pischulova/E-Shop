package com.besttravelproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by А on 09.02.15.
 */
public class DaoAuth {
    Connection connection;

    final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/sql_statements");
    final static String FIND_ADMIN_BY_NAME_PASS = resourceBundle.getString("FIND_ADMIN_BY_NAME_PASS");
    final static String FIND_CLIENT_BY_NAME_PASS = resourceBundle.getString("FIND_CLIENT_BY_NAME_PASS");

    public DaoAuth() {
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public String findByName(String name, String password) {
        try {
            PreparedStatement statement1 = connection.prepareStatement(FIND_ADMIN_BY_NAME_PASS);
            System.out.println(FIND_ADMIN_BY_NAME_PASS);
            statement1.setString(1, name);
            statement1.setString(2, password);
            ResultSet resultSet = statement1.executeQuery();
            if (resultSet.next()){
                return "admin";
            }
            PreparedStatement statement2 = connection.prepareStatement(FIND_CLIENT_BY_NAME_PASS);
            statement2.setString(1, name);
            statement2.setString(2, password);
            resultSet = statement2.executeQuery();
            if (resultSet.next()){
                return "client";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "not found";
    }
}
