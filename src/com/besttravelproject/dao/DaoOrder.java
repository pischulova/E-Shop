package com.besttravelproject.dao;

import com.besttravelproject.model.Client;
import com.besttravelproject.model.Order;
import com.besttravelproject.model.Product;

import java.sql.*;
import java.util.ArrayList;
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
    final static String FIND_ALL_ORDERS = resourceBundle.getString("FIND_ALL_ORDERS");
    final static String FIND_CLIENTS_ORDERS = resourceBundle.getString("FIND_CLIENTS_ORDERS");
    final static String FIND_ORDER_INFO = resourceBundle.getString("FIND_ORDER_INFO");
    final static String FIND_ORDER_CONTENTS = resourceBundle.getString("FIND_ORDER_CONTENTS");
    final static String APPROVE_ORDER = resourceBundle.getString("APPROVE_ORDER");

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
            e.printStackTrace();
        }
        return false;
    }

    public List<Order> findAllOrders() {
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(FIND_ALL_ORDERS);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Client client = new Client();
                client.setName(resultSet.getString(1));
                Order order = new Order();
                order.setId(resultSet.getInt(2));
                order.setDate(resultSet.getDate(3));
                order.setAmount(resultSet.getInt(4));
                order.setIsApproved(resultSet.getInt(5));
                order.setClient(client);
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Order> findClientsOrders(int clientId) {
        List<Order> list = new ArrayList<>();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(FIND_CLIENTS_ORDERS);
            statement.setInt(1, clientId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt(1));
                order.setDate(resultSet.getDate(2));
                order.setAmount(resultSet.getInt(3));
                order.setIsApproved(resultSet.getInt(4));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Order findOrderInfo(int orderId) {
        Order order = new Order();
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(FIND_ORDER_INFO);
            statement.setInt(1, orderId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                order.setId(resultSet.getInt(1));
                order.setDate(resultSet.getDate(2));
                order.setAmount(resultSet.getInt(3));
                order.setIsApproved(resultSet.getInt(4));
                Client client = new Client();
                client.setName(resultSet.getString(5));
                order.setClient(client);
            }
            statement = connection.prepareStatement(FIND_ORDER_CONTENTS);
            statement.setInt(1, orderId);
            resultSet = statement.executeQuery();
            List<Product> list = new ArrayList<>();
            while(resultSet.next()) {
                Product p = new Product();
                p.setId(resultSet.getInt(1));
                list.add(p);
            }
            order.setProducts(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public void approveOrder(int orderId) {
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement(APPROVE_ORDER);
            statement.setInt(1, orderId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
