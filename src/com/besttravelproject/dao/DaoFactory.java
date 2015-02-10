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

    public static DaoAuth getDaoAuth() throws SQLException {
        DaoAuth daoAuth = new DaoAuth();
        if (dataSource.getConnection() == null)
            System.out.println("datasource is null");

        daoAuth.setConnection(dataSource.getConnection());
        return daoAuth;
    }
}
