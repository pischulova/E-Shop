package com.besttravelproject.command.flightCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoFlight;
import com.besttravelproject.model.Country;
import com.besttravelproject.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by А on 16.02.15.
 */
public class FindFlightCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int flightId = Integer.parseInt(request.getParameter("flight"));
        try {
            DaoFlight daoFlight = DaoFactory.getDaoFlight();
            Product product = null;
            if (flightId != 0) {
                product = daoFlight.findProductInfo(flightId);
            }
            session.setAttribute("product", product);
            List<Country> countries = daoFlight.findAllCountries();
            session.setAttribute("countriesList", countries);
            DaoFactory.closeDaoFlight(daoFlight);
            response.sendRedirect("/edit_flight");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
