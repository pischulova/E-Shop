package com.besttravelproject.dao;

import com.besttravelproject.model.Product;

import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by А on 17.02.15.
 */
public class DaoOrder {
    Connection connection;

    final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/sql_statements");
    final static String ADD_ORDER = resourceBundle.getString("ADD_ORDER");
    final static String FIND_LAST_ID = resourceBundle.getString("FIND_LAST_ID");
    final static String ADD_ORDER_CONTENTS = resourceBundle.getString("ADD_ORDER_CONTENTS");

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

    public boolean addOrder(int clientId, Date date, List<Product> cart, int sum) {
        try {
            PreparedStatement statement1 = connection.prepareStatement(ADD_ORDER);
            statement1.setDate(1, date);
            statement1.setInt(2, clientId);
            statement1.setInt(3, sum);
            statement1.executeUpdate();
            statement1 = connection.prepareStatement(FIND_LAST_ID);
            ResultSet resultSet = statement1.executeQuery();
            int orderId = 0;
            while(resultSet.next()) {
                orderId = resultSet.getInt(1);
            }
            if (orderId != 0) {
                for (Product product : cart) {
                    statement1 = connection.prepareStatement(ADD_ORDER_CONTENTS);
                    statement1.setInt(1, orderId);
                    statement1.setInt(2, product.getId());
                    statement1.executeUpdate();
                }
            }
            return true;
        } catch (SQLException e) {

        }
        return false;
    }

}
