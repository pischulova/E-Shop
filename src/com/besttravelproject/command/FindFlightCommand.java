package com.besttravelproject.command;

import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoFlight;
import com.besttravelproject.model.Country;
import com.besttravelproject.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by А on 16.02.15.
 */
public class FindFlightCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int flightId = Integer.parseInt(request.getParameter("flight"));
        try {
            DaoFlight daoFlight = DaoFactory.getDaoFlight();
            Product product = null;
            if (flightId != 0) {
                product = daoFlight.findProductInfo(flightId);
            }
            request.setAttribute("product", product);
            List<Country> countries = daoFlight.findAllCountries();
            request.setAttribute("countriesList", countries);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/edit_flight.jsp");
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