package com.besttravelproject.command.userCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoUser;
import com.besttravelproject.model.Administrator;
import com.besttravelproject.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by А on 08.01.15.
 */
public class AuthCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        RequestDispatcher requestDispatcher;
        if (name!=null && password!= null) {
            DaoUser daoUser = null;
            try {
                daoUser = DaoFactory.getDaoUser();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String foundUser = daoUser.findByNamePass(name, password);

            if (foundUser.equals("not found")) {
                requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/default.jsp");
            } else {
                HttpSession session = request.getSession(true);
                User user = null;

                if (foundUser.equals("admin")) {
                    user = new Administrator();
                    session.setAttribute("isAdmin", "true");
                } else if (foundUser.equals("client")) {
                    user = daoUser.findUserInfo(name);
                    session.setAttribute("isAdmin", "false");
                }
                requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/home.jsp");
                user.setLogin(name);
                user.setPassword(password);
                session.setAttribute("user", user);
                DaoFactory.closeDaoUser(daoUser);
            }
        } else {
            requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/default.jsp");
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
