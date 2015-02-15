package com.besttravelproject.command;

import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoUser;
import com.besttravelproject.model.Administrator;
import com.besttravelproject.model.Client;
import com.besttravelproject.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by А on 08.01.15.
 */
public class AuthCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        RequestDispatcher requestDispatcher = null;
        if (name!=null && password!= null) {
            DaoUser daoUser = null;
            try {
                daoUser = DaoFactory.getDaoAuth();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            String foundUser = daoUser.findByName(name, password);

            if (foundUser.equals("not found")) {
                requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/default.jsp");
            } else {
                HttpSession session = request.getSession(true);
                User user = null;

                if (foundUser.equals("admin")) {
                    user = new Administrator();
                    session.setAttribute("isAdmin", "true");
                    requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/main_admin.jsp");
                } else if (foundUser.equals("client")) {
                    user = new Client();
                    List<String> info = daoUser.findUserInfo(name);
                    if (!info.isEmpty()) {
                        user.setName(info.get(0));
                        user.setSurname(info.get(1));
                        user.setEmail(info.get(2));
                        user.setPhone(info.get(3));
                    }
                    session.setAttribute("isAdmin", "false");
                    requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/main_client.jsp");
                }
                user.setLogin(name);
                user.setPassword(password);
                session.setAttribute("user", user);
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
