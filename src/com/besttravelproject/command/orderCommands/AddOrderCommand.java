package com.besttravelproject.command.orderCommands;

import com.besttravelproject.command.Command;
import com.besttravelproject.dao.DaoFactory;
import com.besttravelproject.dao.DaoOrder;
import com.besttravelproject.model.Product;
import com.besttravelproject.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by А on 18.02.15.
 */
public class AddOrderCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        int sum = Integer.parseInt(request.getParameter("sum"));
        Date date = new Date(Calendar.getInstance().getTimeInMillis());

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int clientId = user.getId();
        List<Product> cart = user.getCart();
        try {
            DaoOrder daoOrder = DaoFactory.getDaoOrder();
            boolean success = daoOrder.addOrder(clientId, date, cart, sum);
            if (success) {
                session.setAttribute("orderSent", "true");
            }
            cart = new ArrayList<>();
            user.setCart(cart);
            DaoFactory.closeDaoOrder(daoOrder);
            response.sendRedirect("/cart");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
