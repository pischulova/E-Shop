package com.besttravelproject.command.orderCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoFlight;
import com.besttravelproject.model.Product;
import com.besttravelproject.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by А on 17.02.15.
 */
public class CartCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        List<Product> cart = user.getCart();
        if (cart == null)
            cart = new ArrayList<>();

        int flightId = Integer.parseInt(request.getParameter("flightId"));
        String action = request.getParameter("action");

        if (action.equals("add")) {
            try {
                DaoFlight daoFlight = DaoFactory.getDaoFlight();
                Product product = daoFlight.findProductInfoLang(flightId);
                cart.add(product);
                DaoFactory.closeDaoFlight(daoFlight);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            Iterator iter = cart.iterator();
            while (iter.hasNext()) {
                Product item = (Product)iter.next();
                if (item.getId() == flightId)
                    iter.remove();
            }
        }
        user.setCart(cart);
        session.setAttribute("user", user);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/jsp/cart.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
