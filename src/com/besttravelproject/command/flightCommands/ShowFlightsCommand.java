package com.besttravelproject.command.flightCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoFlight;
import com.besttravelproject.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by А on 15.02.15.
 */
public class ShowFlightsCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        String country = request.getParameter("country");
        String city = request.getParameter("city");
        try {
            DaoFlight daoFlight = DaoFactory.getDaoFlight();
            List<Product> flights;
            if (city != null & !city.equals("")) {
                flights = daoFlight.findByCity(city);
            } else if (country != null & !country.equals("")) {
                flights = daoFlight.findByCountry(country);
            } else {
                flights = daoFlight.findAll();
            }
            request.setAttribute("flightsList", flights);
            DaoFactory.closeDaoFlight(daoFlight);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/flights");
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
