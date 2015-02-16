package com.besttravelproject.command;

import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoFlight;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by А on 16.02.15.
 */
public class EditFlightCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String nameEn = request.getParameter("nameEn");
        System.out.println(nameEn);
        String nameRu = request.getParameter("nameRu");
        int countryId = Integer.parseInt(request.getParameter("countryId"));
        int price = Integer.parseInt(request.getParameter("price"));
        try {
            DaoFlight daoFlight = DaoFactory.getDaoFlight();
            daoFlight.editFlight(nameEn, nameRu, countryId, price, productId);
            request.setAttribute("flightChanged", "true");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/flights.jsp");
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
