package com.besttravelproject.dao;

import com.besttravelproject.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by А on 09.02.15.
 */
public class DaoUser {
    Connection connection;

    final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/sql_statements");
    final static String FIND_ADMIN_BY_NAME_PASS = resourceBundle.getString("FIND_ADMIN_BY_NAME_PASS");
    final static String FIND_CLIENT_BY_NAME_PASS = resourceBundle.getString("FIND_CLIENT_BY_NAME_PASS");
    final static String FIND_CLIENT_INFO = resourceBundle.getString("FIND_CLIENT_INFO");
    final static String FIND_ALL_CLIENTS = resourceBundle.getString("FIND_ALL_CLIENTS");
    final static String FIND_CLIENTS_ORDER_AMOUNT = resourceBundle.getString("FIND_CLIENTS_ORDER_AMOUNT");
    final static String MAKE_CLIENT_BAD = resourceBundle.getString("MAKE_CLIENT_BAD");

    public DaoUser() {
    }

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

    public String findByName(String name, String password) {
        try {
            PreparedStatement statement1 = connection.prepareStatement(FIND_ADMIN_BY_NAME_PASS);
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

    public List<String> findUserInfo(String name) {
        List<String> info = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_CLIENT_INFO);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                info.add(resultSet.getString(1));
                info.add(resultSet.getString(2));
                info.add(resultSet.getString(3));
                info.add(resultSet.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return info;
    }

    public List<Client> findAllClients(String state) {
        List<Client> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_CLIENTS);
            if (state.equals("good")) {
                statement.setBoolean(1, false);
            } else if (state.equals("bad")) {
                statement.setBoolean(1, true);
            }
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Client c = new Client();
                int id = resultSet.getInt(1);
                PreparedStatement statement2 = connection.prepareStatement(FIND_CLIENTS_ORDER_AMOUNT);
                statement2.setInt(1, id);
                ResultSet resultSet2 = statement2.executeQuery();
                int orderCount = 0;
                if(resultSet2.next()) {
                    orderCount = resultSet2.getInt(1);
                }
                c.setId(id);
                c.setName(resultSet.getString(2));
                c.setSurname(resultSet.getString(3));
                c.setEmail(resultSet.getString(4));
                c.setPhone(resultSet.getString(5));
                c.setOrderAmount(orderCount);
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void changeClientStatus(int id, String action) {
        try {
            PreparedStatement statement = connection.prepareStatement(MAKE_CLIENT_BAD);
            if (action.equals("add"))
                statement.setBoolean(1, true);
            else if (action.equals("remove"))
                statement.setBoolean(1, false);
            statement.setInt(2, id);
            statement.executeUpdate();
            } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
