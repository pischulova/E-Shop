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

    String language = Locale.getDefault().getLanguage();

    final static ResourceBundle resourceBundle = ResourceBundle.getBundle("resources/sql_statements");
    final static String FIND_FLIGHT_BY_COUNTRY_EN = resourceBundle.getString("FIND_FLIGHT_BY_COUNTRY_EN");
    final static String FIND_FLIGHT_BY_CITY_EN = resourceBundle.getString("FIND_FLIGHT_BY_CITY_EN");
    final static String FIND_ALL_FLIGHTS_EN = resourceBundle.getString("FIND_ALL_FLIGHTS_EN");
    final static String FIND_FLIGHT_BY_COUNTRY_RU = resourceBundle.getString("FIND_FLIGHT_BY_COUNTRY_RU");
    final static String FIND_FLIGHT_BY_CITY_RU = resourceBundle.getString("FIND_FLIGHT_BY_CITY_RU");
    final static String FIND_ALL_FLIGHTS_RU = resourceBundle.getString("FIND_ALL_FLIGHTS_RU");
    final static String FIND_FLIGHT_INFO = resourceBundle.getString("FIND_FLIGHT_INFO");
    final static String FIND_FLIGHT_INFO_LANG = resourceBundle.getString("FIND_FLIGHT_INFO_LANG");
    final static String FIND_ALL_COUNTRIES = resourceBundle.getString("FIND_ALL_COUNTRIES");
    final static String EDIT_FLIGHT = resourceBundle.getString("EDIT_FLIGHT");

    public DaoFlight() {}

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

    public Product findProductInfo(int id) {
        Product product = new Product();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_FLIGHT_INFO);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                product.setId(resultSet.getInt(1));
                product.setNameEn(resultSet.getString(2));
                product.setNameRu(resultSet.getString(3));
                product.setPrice(resultSet.getInt(4));
                Country country = new Country();
                country.setId(resultSet.getInt(5));
                product.setCountry(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Product findProductInfoLang(int id) {
        Product product = new Product();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_FLIGHT_INFO_LANG);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            Country country = new Country();

            while(resultSet.next()) {
                if (language.equals("en")) {
                    product.setName(resultSet.getString(1));
                    country.setName(resultSet.getString(4));
                } else {
                    product.setName(resultSet.getString(2));
                    country.setName(resultSet.getString(5));
                }
                product.setPrice(resultSet.getInt(3));
                product.setCountry(country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<Country> findAllCountries() {
        List<Country> list = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL_COUNTRIES);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Country c = new Country();
                c.setId(resultSet.getInt(1));
                c.setNameEn(resultSet.getString(2));
                c.setNameRu(resultSet.getString(3));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void editFlight(String nameEn, String nameRu, int countryId, int price, int flightId) {
        try {
            PreparedStatement statement = connection.prepareStatement(EDIT_FLIGHT);
            statement.setString(1, nameEn);
            statement.setString(2, nameRu);
            statement.setInt(3, countryId);
            statement.setInt(4, price);
            statement.setInt(5, flightId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
