package com.besttravelproject.command.userCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.*;
import com.besttravelproject.model.Client;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by А on 17.02.15.
 */
public class ShowClientsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            DaoUser daoUser = DaoFactory.getDaoUser();
            List<Client> goodClients = daoUser.findAllClients("good");
            List<Client> badClients = daoUser.findAllClients("bad");
            request.setAttribute("goodClientsList", goodClients);
            request.setAttribute("badClientsList", badClients);
            DaoFactory.closeDaoUser(daoUser);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/clients.jsp");
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
