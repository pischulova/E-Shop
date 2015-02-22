package com.besttravelproject.command.userCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoUser;
import com.besttravelproject.model.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            HttpSession session = request.getSession();
            DaoUser daoUser = DaoFactory.getDaoUser();
            List<Client> goodClients = daoUser.findAllClients("good");
            List<Client> badClients = daoUser.findAllClients("bad");
            session.setAttribute("goodClientsList", goodClients);
            session.setAttribute("badClientsList", badClients);

            DaoFactory.closeDaoUser(daoUser);
            response.sendRedirect("/clients");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
