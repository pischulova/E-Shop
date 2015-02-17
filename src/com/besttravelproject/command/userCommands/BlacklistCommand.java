package com.besttravelproject.command.userCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by А on 17.02.15.
 */
public class BlacklistCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int clientId = Integer.parseInt(request.getParameter("clientId"));
        String action = request.getParameter("action");
        try {
            DaoUser daoUser = DaoFactory.getDaoUser();
            daoUser.changeClientStatus(clientId, action);
            DaoFactory.closeDaoUser(daoUser);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/auth?command=show_clients");
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
