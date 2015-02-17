package com.besttravelproject.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by А on 09.02.15.
 */
public class DaoFactory {
    private static DataSource dataSource;
    static {
        try {
            InitialContext initialContext = new InitialContext();
            dataSource = (DataSource)initialContext.lookup("java:comp/env/jdbc/e-shopdb");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static DaoUser getDaoUser() throws SQLException {
        DaoUser daoUser = new DaoUser();
        Connection connection = dataSource.getConnection();
        if (connection==null) {
            System.out.println("Connection ololo");
        } else
            daoUser.setConnection(connection);
        return daoUser;
    }

    public static DaoFlight getDaoFlight() throws SQLException {
        DaoFlight daoFlight = new DaoFlight();
        Connection connection = dataSource.getConnection();
        daoFlight.setConnection(connection);
        return daoFlight;
    }

    public static DaoOrder getDaoOrder() throws SQLException {
        DaoOrder daoOrder = new DaoOrder();
        Connection connection = dataSource.getConnection();
        daoOrder.setConnection(connection);
        return daoOrder;
    }

    public static void closeDaoOrder(DaoOrder daoOrder) {
        daoOrder.closeConnection();
    }

    public static void closeDaoUser(DaoUser daoUser) {
        daoUser.closeConnection();
    }

    public static void closeDaoFlight(DaoFlight daoFlight) {
        daoFlight.closeConnection();
    }
}
