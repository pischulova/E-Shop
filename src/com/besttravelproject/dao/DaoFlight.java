package com.besttravelproject.dao;

import com.besttravelproject.model.Country;
import com.besttravelproject.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by А on 15.02.15.
 */
public class DaoFlight {
    Connection connection;

    final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/sql_statements");

    final static String FIND_FLIGHT_BY_COUNTRY_EN = resourceBundle.getString("FIND_FLIGHT_BY_COUNTRY_EN");
    final static String FIND_FLIGHT_BY_CITY_EN = resourceBundle.getString("FIND_FLIGHT_BY_CITY_EN");
    final static String FIND_ALL_FLIGHTS_EN = resourceBundle.getString("FIND_ALL_FLIGHTS_EN");
    final static String FIND_FLIGHT_BY_COUNTRY_RU = resourceBundle.getString("FIND_FLIGHT_BY_COUNTRY_RU");
    final static String FIND_FLIGHT_BY_CITY_RU = resourceBundle.getString("FIND_FLIGHT_BY_CITY_RU");
    final static String FIND_ALL_FLIGHTS_RU = resourceBundle.getString("FIND_ALL_FLIGHTS_RU");
    String language = Locale.getDefault().getLanguage();

    public DaoFlight() {
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public List<Product> findByCountry(String country) {
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement statement;
            if (language.equals("en")) {
                statement = connection.prepareStatement(FIND_FLIGHT_BY_COUNTRY_EN);
            } else {
                statement = connection.prepareStatement(FIND_FLIGHT_BY_COUNTRY_RU);
            }
            statement.setString(1, country);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Country c = new Country();
                c.setName(resultSet.getString(1));
                Product p = new Product();
                p.setCountry(c);
                p.setName(resultSet.getString(2));
                p.setPrice(resultSet.getInt(3));
                p.setId(resultSet.getInt(4));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> findByCity(String city) {
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement statement;
            if (language.equals("en")) {
                statement = connection.prepareStatement(FIND_FLIGHT_BY_CITY_EN);
            } else {
                statement = connection.prepareStatement(FIND_FLIGHT_BY_CITY_RU);
            }
            statement.setString(1, "%" + city + "%");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Country c = new Country();
                c.setName(resultSet.getString(1));
                Product p = new Product();
                p.setCountry(c);
                p.setName(resultSet.getString(2));
                p.setPrice(resultSet.getInt(3));
                p.setId(resultSet.getInt(4));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try {
            PreparedStatement statement;
            if (language.equals("en")) {
                statement = connection.prepareStatement(FIND_ALL_FLIGHTS_EN);
            } else {
                statement = connection.prepareStatement(FIND_ALL_FLIGHTS_RU);
            }
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Country c = new Country();
                c.setName(resultSet.getString(1));
                Product p = new Product();
                p.setCountry(c);
                p.setName(resultSet.getString(2));
                p.setPrice(resultSet.getInt(3));
                p.setId(resultSet.getInt(4));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
