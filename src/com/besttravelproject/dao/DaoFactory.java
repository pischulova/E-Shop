package com.besttravelproject.dao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
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

    public static DaoUser getDaoAuth() throws SQLException {
        DaoUser daoUser = new DaoUser();
        if (dataSource.getConnection() == null)
            System.out.println("datasource is null");

        daoUser.setConnection(dataSource.getConnection());
        return daoUser;
    }

    public static DaoFlight getDaoFlight() throws SQLException {
        DaoFlight daoFlight = new DaoFlight();
        if (dataSource.getConnection() == null)
            System.out.println("datasource is null");

        daoFlight.setConnection(dataSource.getConnection());
        return daoFlight;
    }
}
