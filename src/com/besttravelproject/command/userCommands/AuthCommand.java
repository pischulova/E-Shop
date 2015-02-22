package com.besttravelproject.command.userCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoUser;
import com.besttravelproject.model.Administrator;
import com.besttravelproject.model.User;

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
        try {
            DaoUser daoUser = DaoFactory.getDaoUser();
            String foundUser = daoUser.findByNamePass(name, password);

            if (foundUser.equals("not found")) {
                DaoFactory.closeDaoUser(daoUser);
                HttpSession session = request.getSession();
                session.setAttribute("error_message", "bad_login");
                response.sendRedirect("/error");
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
                user.setLogin(name);
                user.setPassword(password);
                session.setAttribute("user", user);

                DaoFactory.closeDaoUser(daoUser);
                response.sendRedirect("/home");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
