package com.besttravelproject.command.flightCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Created by А on 16.02.15.
 */
public class EditFlightCommand implements Command {
    private static final Logger logger = LogManager.getLogger("appLogger");

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        int productId = Integer.parseInt(request.getParameter("productId"));
        String nameEn = request.getParameter("nameEn");
        String nameRu = request.getParameter("nameRu");
        int countryId = Integer.parseInt(request.getParameter("countryId"));
        int price = Integer.parseInt(request.getParameter("price"));

        try {
            DaoFlight daoFlight = DaoFactory.getDaoFlight();
            boolean isSuccessful = daoFlight.editFlight(nameEn, nameRu, countryId, price, productId);
            if (isSuccessful) {
                session.setAttribute("flightChanged", true);
                session.removeAttribute("flightsList");
                logger.info("DBUpdate");
            } else {
                session.setAttribute("error_message", "db_error");
            }
            DaoFactory.closeDaoFlight(daoFlight);
            response.sendRedirect("/flights");
        } catch (IOException e) {
            logger.error("RedirectError", e);
        } catch (SQLException e) {
            logger.error("DBError", e);
        }
    }
}
